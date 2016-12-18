package com.koda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;


public class HuffmanTree<NodeType extends HuffmanTreeNode> 
{
	private TreeNodeDecorator<NodeType> m_Tree;
	
	public HuffmanTree(ArrayList<NodeType> alphabet) 
	{
		//int tree_size = (int)Math.floor((Math.log(alphabet.size())/Math.log(2.0))); //Max elements in binary tree
		m_Tree = null;
		
		Comparator<TreeNodeDecorator<NodeType>> queue_comparator = new Comparator<TreeNodeDecorator<NodeType>>()
		{
			@Override
			public int compare(TreeNodeDecorator<NodeType> n1, TreeNodeDecorator<NodeType> n2)
			{
				return (int)(n1.getWeight() - n2.getWeight());
			}
		};
		
		PriorityQueue<TreeNodeDecorator<NodeType>> queue =  new PriorityQueue<>(alphabet.size(), queue_comparator);
		for (NodeType node : alphabet)
		{
			queue.add(new TreeNodeDecorator<NodeType>(node));
		}
		
		TreeNodeDecorator first = null;
		TreeNodeDecorator second = null;
		while(queue.size() != 1)
		{
			first = queue.remove();
			second = queue.remove();
			//check if first and second are trees or simple elements
			boolean first_is_tree = first.hasTreeAssociated();
			boolean second_is_tree = second.hasTreeAssociated();
			
			if(first_is_tree && second_is_tree)
			{
				//if both of them are trees, merge them into one
				TreeNodeDecorator combined_trees = new TreeNodeDecorator();
				
				combined_trees.setAtIndex(TreeNodeDecorator.ROOT_INDEX, new HuffmanTreeNode(first.getWeight() + second.getWeight()));
				moveTreeNode(combined_trees, TreeNodeDecorator.ROOT_LEFT_CHILD, first, TreeNodeDecorator.ROOT_INDEX);
				moveTreeNode(combined_trees, TreeNodeDecorator.ROOT_RIGHT_CHILD, second, TreeNodeDecorator.ROOT_INDEX);
				
				queue.add(combined_trees);
			}
			else if(!first_is_tree && !second_is_tree)
			{
				//if both of them are simple elements, create a new tree
				TreeNodeDecorator decorated_tree_node = new TreeNodeDecorator();
				
				decorated_tree_node.setAtIndex(TreeNodeDecorator.ROOT_INDEX, new HuffmanTreeNode(first.getWeight() + second.getWeight()));
				decorated_tree_node.setAtIndex(TreeNodeDecorator.ROOT_LEFT_CHILD, first.getTreeNode());
				decorated_tree_node.setAtIndex(TreeNodeDecorator.ROOT_RIGHT_CHILD, second.getTreeNode());
				decorated_tree_node.recalculateWeights();
				
				queue.add(decorated_tree_node);
			}
			else 
			{
				TreeNodeDecorator extended_tree = new TreeNodeDecorator();
				//if one of them is element and the other a tree, merge them into new tree
				if(first_is_tree)
				{
					extended_tree.setAtIndex(TreeNodeDecorator.ROOT_INDEX, new HuffmanTreeNode(first.getWeight() + second.getWeight()));
					extended_tree.setAtIndex(TreeNodeDecorator.ROOT_RIGHT_CHILD, second.getTreeNode());
					moveTreeNode(extended_tree, TreeNodeDecorator.ROOT_LEFT_CHILD, first, TreeNodeDecorator.ROOT_INDEX);
					
					queue.add(extended_tree);
				}
				else
				{
					extended_tree.setAtIndex(TreeNodeDecorator.ROOT_INDEX, new HuffmanTreeNode(first.getWeight() + second.getWeight()));
					extended_tree.setAtIndex(TreeNodeDecorator.ROOT_LEFT_CHILD, first.getTreeNode());
					moveTreeNode(extended_tree, TreeNodeDecorator.ROOT_RIGHT_CHILD, second, TreeNodeDecorator.ROOT_INDEX);
				}
				
				queue.add(extended_tree);
			}
		}
		
		m_Tree = queue.remove();
	}
	
	/**
	 * 
	 * @param mainTreeIndex
	 * @param subTreeNode
	 * @param subTreeIndex
	 * BEHOLD THE POWER OF GLORIOUS RECURSION!
	 */
	private void moveTreeNode(TreeNodeDecorator<NodeType> mainTree, int mainTreeIndex, TreeNodeDecorator<NodeType> subTreeNode, int subTreeIndex)
	{
		if(mainTreeIndex == 0 || subTreeIndex == 0)
		{
			throw new IllegalArgumentException("Function moveTreeNode won't work if any tree index is zero!");
		}
		
		mainTree.setAtIndex(mainTreeIndex, subTreeNode.atIndex(subTreeIndex));
		
		if(subTreeNode.atIndex(HuffmanTreeNode.leftChild(subTreeIndex)) != null)
		{
			moveTreeNode(mainTree, HuffmanTreeNode.leftChild(mainTreeIndex), subTreeNode, HuffmanTreeNode.leftChild(subTreeIndex));
		}
		if(subTreeNode.atIndex(HuffmanTreeNode.rightChild(subTreeIndex)) != null)
		{
			moveTreeNode(mainTree, HuffmanTreeNode.rightChild(mainTreeIndex), subTreeNode, HuffmanTreeNode.rightChild(subTreeIndex));
		}
	}
	
	public HashMap<NodeType, BinaryBox> getCodeDictionary()
	{
		return m_Tree.getCodes();
	}
}
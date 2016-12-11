package com.koda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


public class HuffmanTree<NodeType extends HuffmanTreeNode> 
{

	private ArrayList<HuffmanTreeNode> m_Tree;
	
	
	public HuffmanTree(ArrayList<NodeType> alphabet) 
	{
		int tree_size = (int)Math.floor((Math.log(alphabet.size())/Math.log(2.0))); //Max elements in binary tree
		m_Tree = new ArrayList<HuffmanTreeNode>(tree_size);
		
		Comparator<TreeNodeDecorator> queue_comparator = new Comparator<TreeNodeDecorator>()
		{
			@Override
			public int compare(TreeNodeDecorator n1, TreeNodeDecorator n2)
			{
				return (int)(n1.getWeight() - n2.getWeight());
			}
		};
		
		PriorityQueue<TreeNodeDecorator> queue =  new PriorityQueue<>(alphabet.size(), queue_comparator);
		for (NodeType node : alphabet)
		{
			queue.add(new TreeNodeDecorator(node));
		}
		
		TreeNodeDecorator first = null;
		TreeNodeDecorator second = null;
		while(!queue.isEmpty())
		{
			first = queue.remove();
			second = queue.remove();
			//check if first and second are trees or simple elements
			boolean first_is_tree = first.hasTreeAssociated();
			boolean second_is_tree = second.hasTreeAssociated();
			
			if(first_is_tree && second_is_tree)
			{
				//if both of them are trees, merge them into one
			}
			else if(!first_is_tree && !second_is_tree)
			{
				//if both of them are simple elements, create a new tree
			}
			else 
			{
				//if one of them is element and the other a tree, merge them into new tree
			}
			
			
			
			
			
			
			
		}
	}
	
	
	private int leftChildIndex(int parentIndex)
	{
		return parentIndex * 2;
	}
	
	private int rightChildIndex(int parentIndex)
	{
		return parentIndex * 2 + 1;
	}
	
	private void extendTree(NodeType f, NodeType s)
	{
		
	}
	/**
	 * 
	 * @param mainTreeIndex
	 * @param subTreeNode
	 * @param subTreeIndex
	 * BEHOLD THE POWER OF GLORIOUS RECURSION!
	 */
	private void moveTreeNode(int mainTreeIndex, TreeNodeDecorator subTreeNode, int subTreeIndex)
	{
		if(mainTreeIndex == 0)
		{
			throw new IllegalArgumentException("Function moveTreeNode won't work if main tree index is zero!");
		}
		
		if(subTreeIndex == 0)
		{
			throw new IllegalArgumentException("Function moveTreeNode won't work if sub tree index is zero!");
		}
		
		m_Tree.set(mainTreeIndex, subTreeNode.atIndex(subTreeIndex));
		
		if(subTreeNode.atIndex(leftChildIndex(subTreeIndex)) != null)
		{
			moveTreeNode(leftChildIndex(mainTreeIndex), subTreeNode, leftChildIndex(subTreeIndex));
		}
		else if(subTreeNode.atIndex(rightChildIndex(subTreeIndex)) != null)
		{
			moveTreeNode(rightChildIndex(mainTreeIndex), subTreeNode, rightChildIndex(subTreeIndex));
		}
	}
	
	
}

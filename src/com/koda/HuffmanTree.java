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
		
		Comparator<NodeType> queue_comparator = new Comparator<NodeType>()
		{
			@Override
			public int compare(NodeType n1, NodeType n2)
			{
				return (int)(n1.getWeight() - n2.getWeight());
			}
		};
		
		PriorityQueue<NodeType> queue =  new PriorityQueue<>(alphabet.size(), queue_comparator);
		for (NodeType node : alphabet)
		{
			queue.add(node);
		}
		
		NodeType first = null;
		NodeType second = null;
		while(!queue.isEmpty())
		{
			first = queue.remove();
			second = queue.remove();
			
			
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
	
	
}

package com.koda;

import java.util.ArrayList;

public class TreeNodeDecorator 
{
	private HuffmanTreeNode m_TreeNode;
	
	private ArrayList<HuffmanTreeNode> m_Tree;
	
	public static final int ROOT_INDEX = 1;
	public static final int ROOT_LEFT_CHILD = 2;
	public static final int ROOT_RIGHT_CHILD = 3;
	
	public TreeNodeDecorator()
	{
		m_TreeNode = null;
		m_Tree = new ArrayList<>();
	}
	
	public TreeNodeDecorator(HuffmanTreeNode node)
	{	
		m_TreeNode = node;
		m_Tree = new ArrayList<>();
	}
	
	public HuffmanTreeNode atIndex(int index)
	{
		if(m_Tree != null)
		{
			if(m_Tree.size() - 1 < index)
			{
				return null;
			}
			
			return m_Tree.get(index);
		}
		else
		{
			return null;
		}
	}
	
	public HuffmanTreeNode getTreeNode()
	{
		return m_TreeNode;
	}
	
	public void setAtIndex(int index, HuffmanTreeNode node)
	{
		if(m_Tree.size() - 1 < index)
		{
			m_Tree.ensureCapacity(index + 1);
			//throw new IndexOutOfBoundsException("Tree array index out of boundary!");
			m_Tree.set(index, node);
		}
	}
	
	public void recalculateWeights()
	{
		calculateNodeWeight(ROOT_INDEX);
	}
	
	private long calculateNodeWeight(int startIndex)
	{
		long calculated_weight = 0L;
		
		if(m_TreeNode != null)
		{
			return m_TreeNode.getWeight();
		}
		
		if(m_Tree.size() - 1  >= HuffmanTreeNode.leftChild(startIndex))
		{
			if(m_Tree.get(HuffmanTreeNode.leftChild(startIndex)) != null)
			{
				calculated_weight += calculateNodeWeight(HuffmanTreeNode.leftChild(startIndex));
			}
		}
		
		if(m_Tree.size() - 1  >= HuffmanTreeNode.rightChild(startIndex))
		{
			if(m_Tree.get(HuffmanTreeNode.rightChild(startIndex)) != null)
			{
				calculated_weight += calculateNodeWeight(HuffmanTreeNode.rightChild(startIndex));
			}
		}
		
		m_Tree.get(startIndex).setWeight(calculated_weight);
		return calculated_weight;
	}
	
	public boolean hasTreeAssociated()
	{
		if(m_Tree.size() == 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public long getWeight()
	{
		long val = 0L;
		if(m_Tree.size() != 0)
		{
			val = m_Tree.get(ROOT_INDEX).getWeight();
		}
		else
		{
			val = m_TreeNode.getWeight();
		}
		return val;
	}
	
	
}

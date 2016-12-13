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
		initializeTreeArray();
	}
	
	public TreeNodeDecorator(HuffmanTreeNode node)
	{	
		m_TreeNode = node;
		m_Tree = null;
		//initializeTreeArray();
	}
	
	private void initializeTreeArray()
	{
		m_Tree = new ArrayList<>();
		for (int i = 0; i < 10; ++i)
		{
			m_Tree.add(null);
		}
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
			for(int i = m_Tree.size() - 1; i < index; ++i)
			{
				m_Tree.add(null);
			}
		}
		m_Tree.set(index, node);
	}
	
	public void recalculateWeights()
	{
		calculateNodeWeight(ROOT_INDEX);
	}
	
	private long calculateNodeWeight(int startIndex)
	{
		long calculated_weight = 0L;
		boolean has_at_least_one_child = false;
		
		if(m_Tree == null)
		{
			return 0L;
		}
		
		//if(m_Tree.get(startIndex) != null)
		//{
		//	return m_TreeNode.getWeight();
		//}
		
		if(m_Tree.size() - 1 >= HuffmanTreeNode.leftChild(startIndex))
		{
			if(m_Tree.get(HuffmanTreeNode.leftChild(startIndex)) != null)
			{
				has_at_least_one_child = true;
				calculated_weight += calculateNodeWeight(HuffmanTreeNode.leftChild(startIndex));
			}
		}
		
		if(m_Tree.size() - 1  >= HuffmanTreeNode.rightChild(startIndex))
		{
			if(m_Tree.get(HuffmanTreeNode.rightChild(startIndex)) != null)
			{
				has_at_least_one_child = true;
				calculated_weight += calculateNodeWeight(HuffmanTreeNode.rightChild(startIndex));
			}
		}
		
		if(has_at_least_one_child == false)
		{
			return m_Tree.get(startIndex).getWeight();
		}
		
		m_Tree.get(startIndex).setWeight(calculated_weight);
		return calculated_weight;
	}
	
	public boolean hasTreeAssociated()
	{
		if(m_TreeNode != null)
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
		
		if(m_TreeNode != null)
		{
			val = m_TreeNode.getWeight();
		}
		else
		{
			val = m_Tree.get(ROOT_INDEX).getWeight();
		}

		return val;
	}
	
	
}

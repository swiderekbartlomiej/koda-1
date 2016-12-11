package com.koda;

import java.util.ArrayList;

public class TreeNodeDecorator 
{
	private HuffmanTreeNode m_TreeNode;
	
	private ArrayList<HuffmanTreeNode> m_Tree;
	
	public TreeNodeDecorator(HuffmanTreeNode node)
	{	
		m_TreeNode = node;
		m_Tree = new ArrayList<>();
	}
	
	public HuffmanTreeNode atIndex(int index)
	{
		if(m_Tree != null)
		{
			if(m_Tree.size() < index)
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
	
	public void setAtIndex(int index, HuffmanTreeNode node)
	{
		if(m_Tree.size() < index)
		{
			throw new IndexOutOfBoundsException("Tree array index out of boundary!");
		}
		
		m_Tree.set(index, node);
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
			for (HuffmanTreeNode node : m_Tree)
			{
				val += node.getWeight();
			}
		}
		else
		{
			val = m_TreeNode.getWeight();
		}
		return val;
	}
	
	
}

package com.koda;

import java.lang.IllegalArgumentException;

public class HuffmanTreeNode 
{
	private long m_Weight;
	
	public HuffmanTreeNode()
	{
		m_Weight = 0L;
	}
	
	public HuffmanTreeNode(long weight)
	{
		m_Weight = weight;
	}
	
	public long getWeight()
	{
		return m_Weight;
	}
	
	public void setWeight(long w) 
	{
		if(m_Weight < 0L)
		{
			throw new IllegalArgumentException("Tree node weight cannot be zero or negative!");
		}
		
		m_Weight = w;
	}
	
	private boolean equals(HuffmanTreeNode node)
	{
		return m_Weight == node.m_Weight;
	}
	
	@Override
	public boolean equals(Object other)
	{
		if(other instanceof HuffmanTreeNode)
		{
			return this.equals((HuffmanTreeNode)other);
		}
		return false;
	}
	
	@Override
	public int hashCode()
	{
		int prime = 37;
		return (int) (prime + m_Weight);
	}
}

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
	
	public static int leftChild(int parentIndex)
	{
		return parentIndex * 2;
	}
	
	public static int rightChild(int parentIndex)
	{
		return parentIndex * 2 + 1; 
	}
	
	public static int codeLeftNodeMove(int currentCode)
	{
		return currentCode = (currentCode << 1);
	}
	
	public static int codeRightNodeMove(int currentCode)
	{
		currentCode = (currentCode << 1);
		return ++currentCode;
	}
	
	public String getValue(){
		return null;
	}

	public void print() {
		// TODO Auto-generated method stub
		
	}
}
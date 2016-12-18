package com.koda;

public class BinaryBox {
	
	private int value;
	private int spaceUsed;
	
	public BinaryBox()
	{
		this.value = 0;
		this.spaceUsed=0;
	}
	
	public BinaryBox(int binValue, int binaryDigitsUsed)
	{
		if(binaryDigitsUsed < 0 || binaryDigitsUsed > 32)
		{
			throw new IllegalArgumentException("Invalid number of binary digits! passed number:" + binaryDigitsUsed);
		}
		
		this.value = binValue;
		spaceUsed = binaryDigitsUsed;
	}

	public void shiftLeft(int shiftValue) 
	{
		this.value = this.value  << shiftValue;
	}

	public void appendValue(int appendValue) 
	{
		this.value = this.value | appendValue;
	}

	public void increaseSpaceUsed(int spaceUsedByWord) 
	{
		this.spaceUsed += spaceUsedByWord;
	}

	public Integer getValue() 
	{
		return this.value;
	}

	public void forceCloseBox() 
	{
		this.shiftLeft(32-this.spaceUsed);
		
	}
	
	public int returnFreeSpace()
	{
		return 32-this.spaceUsed;
	}

}
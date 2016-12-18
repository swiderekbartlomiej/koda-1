package com.koda;

public class BinaryBox {
	
	private int value;
	private int spaceUsed;
	
	public BinaryBox(){
		this.value = 0;
		this.spaceUsed=0;
	}

	public void shiftLeft(int shiftValue) {
		this.value = this.value  << shiftValue;
	}

	public void appendValue(int appendValue) {
		this.value = this.value | appendValue;
	}

	public void increaseSpaceUsed(int spaceUsedByWord) {
		this.spaceUsed += spaceUsedByWord;
	}

	public Integer getValue() {
		return this.value;
	}

	public void forceCloseBox() {
		this.shiftLeft(32-this.spaceUsed);
		
	}
	
	public int returnFreeSpace(){
		return 32-this.spaceUsed;
	}
	

	

}
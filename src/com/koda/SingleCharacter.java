package com.koda;

public class SingleCharacter extends HuffmanTreeNode
{
	private Character m_Symbol;
	private int m_HashSeed = 17;
	
	public SingleCharacter()
	{
		m_Symbol = null;
	}
	
	public SingleCharacter(Character c)
	{
		setSymbol(c);
	}
	
	public SingleCharacter(Character c, long weight)
	{
		super(weight);
		setSymbol(c);
	}
	
	public void setSymbol(Character c)
	{
		m_Symbol = c;
	}
	
	public Character getSymbol()
	{
		return m_Symbol;
	}
	
	private boolean equals(SingleCharacter other)
	{
		return this.m_Symbol == other.m_Symbol;
	}
	
	@Override
	public boolean equals(Object other)
	{
		if(other instanceof SingleCharacter)
		{
			return this.equals((SingleCharacter)other);
		}
		return false;
	}
	
	@Override
	public int hashCode()
	{
		m_HashSeed = 31 * m_HashSeed + (int)m_Symbol;
		return m_HashSeed;
	}
	
	// Drukuje jakie wartosci symboli są w SingleCharacter i wagę węzła
	@Override
	public void print (){
		System.out.println(m_Symbol+" "+super.getWeight());
	}

	@Override
	public String getValue() {
		return m_Symbol.toString();
		
	}
}

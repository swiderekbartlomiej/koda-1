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
	
	private boolean equals_Kuby(SingleCharacter other)
	{
		return this.m_Symbol == other.m_Symbol;
	}
	
	//@Override
	public boolean equals_Kuby(Object other)
	{
		if(other instanceof SingleCharacter)
		{
			return this.equals((SingleCharacter)other);
		}
		return false;
	}
	
	//MARNA PRÓBA RAFAŁA
	@Override
	public boolean equals(Object other)
	{
		//System.out.println("Wolam Zewnetrzny equals");
		if(other instanceof SingleCharacter)
		{
			return this.equals((SingleCharacter)other);
		}
		return false;
	}
	
	//DALSZA CZESC MARNEJ PROBY
	private boolean equals(SingleCharacter other)
	{
		//System.out.println("Wolam wewnetrzny equals");
		return this.getValue().hashCode() == other.getValue().hashCode();
	}
	
	@Override
	public int hashCode()
	{
		//System.out.println("Wołam hashCode w SingleCharacter: "+this.getValue().hashCode()+" / "+this.getValue());
		return this.getValue().hashCode();
		//m_HashSeed = 31 * m_HashSeed + (int)m_Symbol;
		//return m_HashSeed;
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

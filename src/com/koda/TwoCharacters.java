package com.koda;

public class TwoCharacters extends HuffmanTreeNode
{
	protected Character m_Characters[];
	protected int m_CharactersCount = 2;
	
	public TwoCharacters()
	{
		m_Characters = new Character[m_CharactersCount];
	}
	
	public TwoCharacters(Character first, Character second)
	{
		m_Characters = new Character[m_CharactersCount];
		setCharacters(first, second);
	}
	
	public TwoCharacters(Character first, Character second, long weight)
	{
		super(weight);
		m_Characters = new Character[m_CharactersCount];
		setCharacters(first, second);
	}
	
	public void setCharacters(Character first, Character second)
	{
		m_Characters[0] = first;
		m_Characters[1] = second;
	}
	
	public Character[] getCharacters()
	{
		return m_Characters;
	}
	
	public Character getFirst()
	{
		return m_Characters[0];
	}
	
	public Character getSecond()
	{
		return m_Characters[1];
	}
	
	private boolean equals(TwoCharacters other)
	{
		if(m_Characters[0] == other.m_Characters[0])
		{
			if(m_Characters[1] == other.m_Characters[1])
			{
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean equals(Object other)
	{
		if(other instanceof TwoCharacters)
		{
			return this.equals((TwoCharacters)other);
		}
		return false;
	}
	
	@Override
	public int hashCode()
	{
		int prime = 53;
		return prime + (m_Characters[0] != null ? m_Characters[0].hashCode() : 0) + (m_Characters[1] != null ? m_Characters[1].hashCode() : 0);
	}
	
	@Override
	public void print(){
		System.out.println(m_Characters[0]+""+m_Characters[1]+" "+super.getWeight());
	}

	@Override
	public String getValue() {
		return m_Characters[0].toString()+m_Characters[1].toString();
	}
}

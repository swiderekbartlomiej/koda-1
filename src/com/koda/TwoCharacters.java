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

	@Override
	public boolean equals(Object other)
	{
		if(other instanceof TwoCharacters)
		{
			return this.equals((TwoCharacters)other);
		}
		return false;
	}
	
	private boolean equals(TwoCharacters other)
	{
		return (this.getFirst().hashCode() == other.getFirst().hashCode() && this.getSecond().hashCode() == other.getSecond().hashCode());
	}
	
	@Override
	public int hashCode()
	{
		return this.getValue().hashCode();
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

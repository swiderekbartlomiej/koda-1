package com.koda;

public class ContextCharacter extends TwoCharacters
{
	public ContextCharacter() 
	{
		super();
	}
	
	public ContextCharacter(Character symbol, Character symbolContext) 
	{
		super(symbol, symbolContext);
	}
	
	public ContextCharacter(Character symbol, Character symbolContext, long weight) 
	{
		super(symbol, symbolContext, weight);
	}
	
	public void setSymbol(Character c)
	{
		m_Characters[0] = c;
	}
	
	public void setSymbolContext(Character c)
	{
		m_Characters[1] = c;
	}
	
	public Character getSymbol()
	{
		return m_Characters[0];
	}
	
	public Character getSymbolContext()
	{
		return m_Characters[1];
	}

	
	//@Override
	public boolean equals_Kuby(Object other)
	{
		if((other instanceof ContextCharacter))
		{
			if
			(
				(((ContextCharacter) other).getSymbol() == this.getSymbol()) &&
				(((ContextCharacter) other).getSymbolContext() == this.getSymbol())
			)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		return false;
	}
	
	//MARNA PRÓBA RAFAŁA
		@Override
		public boolean equals(Object other)
		{
			//System.out.println("Wolam Zewnetrzny equals");
			if(other instanceof ContextCharacter)
			{
				return this.equals((ContextCharacter)other);
			}
			return false;
		}
		
		//DALSZA CZESC MARNEJ PROBY
		private boolean equals(ContextCharacter other)
		{
			//System.out.println("Wolam wewnetrzny equals");
			return (this.getFirst().hashCode() == other.getFirst().hashCode() && this.getSecond().hashCode() == other.getSecond().hashCode());
		}
	
//	@Override
//	public int hashCode()
//	{
//		int prime = 57;
//		return prime + (m_Characters[0] != null ? m_Characters[0].hashCode() : 0) + (m_Characters[1] != null ? m_Characters[1].hashCode() : 0);
//	}
	
	@Override
	public void print(){
		System.out.println(m_Characters[0]+"|"+m_Characters[1]+" "+super.getWeight());
	}
	
	@Override
	public String getValue() {
		return m_Characters[0].toString()+m_Characters[1].toString();
	}
}

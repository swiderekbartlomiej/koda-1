package KODA_package;

public enum CodingMethod
{
	HUFFMAN_SINGLE_SYMBOLS ("hss"),
	HUFFMAN_DOUBLE_SYMBOLS ("hds"),
	MARKOV_CONDITION ("mc"),
	NONE ("none");
	
	private String m_ShortName;
	
	private CodingMethod(String cmshort) 
	{
		this.m_ShortName = cmshort;
	}
	
	public String getTag()
	{
		return m_ShortName;
	}
	
	public static String getTags()
	{
		String str = new String();
		
		str += HUFFMAN_SINGLE_SYMBOLS.getTag();
		str += ", ";
		str += HUFFMAN_DOUBLE_SYMBOLS.getTag();
		str += ", ";
		str += MARKOV_CONDITION.getTag();
		
		return str;
	}
	
	public static CodingMethod isImplemented(String codMetTag)
	{
		CodingMethod val = NONE;
		for (CodingMethod CMethod : CodingMethod.values())
		{
			if(CMethod.m_ShortName.equals(codMetTag))
			{
				val = CMethod;
				break;
			}
		}
		return val;
	}
	
	public static CodingMethod getCodingMethod(String tag) throws Exception
	{
		CodingMethod val = isImplemented(tag);
		
		if(val == NONE)
		{
			throw new Exception("Coding method is not implemented");
		}
		
		return val;
	}
}

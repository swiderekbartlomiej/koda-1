package KODA_package;

public enum OperationType
{
	CODING ("cod"),
	DECODING ("decod"),
	NONE ("none");

	private String m_ShortName;
	
	private OperationType(String dshort) 
	{
		this.m_ShortName = dshort;
	}
	
	public String getTag()
	{
		return m_ShortName;
	}
	
	public static String getTags()
	{
		String str = new String();
		
		str += CODING.getTag();
		str += ", ";
		str += DECODING.getTag();
		
		return str;
	}
	
	public static OperationType isImplemented(String opTypTag)
	{
		OperationType val = NONE;
		for (OperationType OpType : OperationType.values())
		{
			if(OpType.m_ShortName.equals(opTypTag))
			{
				val = OpType;
				break;
			}
		}
		return val;
	}
	
	public static OperationType getOperationType(String tag) throws Exception
	{
		OperationType val = isImplemented(tag);
		
		if(val == NONE)
		{
			throw new Exception("This operation is not exist");
		}
		
		return val;
	}
}

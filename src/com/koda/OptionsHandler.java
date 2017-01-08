package KODA_package;

import java.nio.file.*;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;


public class OptionsHandler 
{
	class OptionException extends Exception
	{
		private String m_Description;
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public OptionException(String description) 
		{
			m_Description = description;
		}
		
		public String toString()
		{
			return m_Description;
		}	
		
		public String getMessage()
		{
			return m_Description;
		}
	}
		
	private Path m_FileFullPath;
	private CodingMethod m_CodingType;
	private OperationType m_CodingOrDecoding;
	
	private String m_OptionFileFullPath = "fpath" ;
	private String m_OptionCodingType = "ctype";
	private String m_OptionCodingOrDecoding = "cord";
	
	private String m_OptionFileFullPathDesc = "Path to directory where there is file to coding";
	private String m_OptionCodingTypeDesc = "What is the type of coding";
	private String m_OptionCodingOrDecodingDesc = "Choice between coding or decoding";
	
	private Options m_Options;
	private CommandLine m_CommandLine;
	
	public OptionsHandler(String[] arguments) throws OptionException
	{
		m_Options = new Options();
		
		Option file_dir_path = Option.builder(m_OptionFileFullPath).required(true).hasArg(true).desc(m_OptionFileFullPathDesc).build();
		Option coding_type = Option.builder(m_OptionCodingType).required(true).hasArg(true).desc(m_OptionCodingTypeDesc).build();
		Option operation = Option.builder(m_OptionCodingOrDecoding).required(true).hasArg(true).desc(m_OptionCodingOrDecodingDesc).build();
		
		m_Options.addOption(file_dir_path);
		m_Options.addOption(coding_type);
		m_Options.addOption(operation);
		
		if(arguments.length == 0)
		{
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("KODA Project", m_Options);
		}
		else
		{
			CommandLineParser parser = new DefaultParser();
			
			try
			{
				m_CommandLine = parser.parse(m_Options, arguments);
			}
			catch(ParseException e)
			{
				throw new OptionException("Argument parsing failed, message: " + e.getMessage());
			}

			m_FileFullPath = Paths.get(m_CommandLine.getOptionValue(m_OptionFileFullPath));
			m_FileFullPath = m_FileFullPath.normalize();
			
			try
			{
				m_CodingType = CodingMethod.getCodingMethod(m_CommandLine.getOptionValue(m_OptionCodingType));
			} 
			catch (Exception e)
			{
				throw new OptionException("Coding method is failed, message: " + e.getMessage());
			}
			
			try
			{
				m_CodingOrDecoding = OperationType.getOperationType(m_CommandLine.getOptionValue(m_OptionCodingOrDecoding));
			} 
			catch (Exception e)
			{
				throw new OptionException("Operation type is failed, message: " + e.getMessage());
			}
		}
	}
			
	public CodingMethod getCodingMethod()
	{
		return m_CodingType;
	}
	
	public OperationType getOperationType()
	{
		return m_CodingOrDecoding;
	}
	
	public Path getFileFullPath()
	{
		return m_FileFullPath;
	}
}
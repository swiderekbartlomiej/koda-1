package KODA_package;

import KODA_package.OptionsHandler.OptionException;

public class Test
{
   public static void main( String[] args )
   {	  
      try
      {
		OptionsHandler opHandler = new OptionsHandler(args);
		System.out.println("Ścieżka do pliku: " + opHandler.getFileFullPath().toString());
		System.out.println("Wybrana metoda kodowania: " + opHandler.getCodingMethod().getTag());
		System.out.println("Wybrany tryb pracy (kodowanie/dekodowanie): " + opHandler.getOperationType().getTag());
      }
      catch (OptionException e)
      {
		e.printStackTrace();
	  }
   }
}
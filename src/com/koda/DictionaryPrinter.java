package com.koda;

import java.util.HashMap;
import java.util.Map;
/**
 * Pomocnicza klasa drukarki słownika. Nieistotna z punktu widzenia działania projektu
 * @author koda
 *
 */
public class DictionaryPrinter {
	
	/**
	 * Przyjmuje słownik jako HashMap i wypisuje jego rekordy kolejno na ekran
	 * @param disctionaryHashMap
	 */
	public static void printSCDictionary (HashMap<SingleCharacter, BinaryBox> disctionaryHashMap){
		for (Map.Entry<SingleCharacter, BinaryBox> entry : disctionaryHashMap.entrySet()){
			System.out.println("Klucz: "+entry.getKey().getSymbol().toString()+" wartość: "+entry.getValue().getValue()+" binarnie: "+Integer.toString(entry.getValue().getValue(),2));
		}
	}
	
	public static void printCCDictionary (HashMap<ContextCharacter, BinaryBox> disctionaryHashMap){
		for (Map.Entry<ContextCharacter, BinaryBox> entry : disctionaryHashMap.entrySet()){
			System.out.println("Klucz: "+entry.getKey().getSymbol().toString()+", context :"+entry.getKey().getSymbolContext()+" wartość: "+entry.getValue().getValue()+" binarnie: "+Integer.toString(entry.getValue().getValue(),2));
			if (entry.getKey().getSymbolContext().toString() == "^"){
				System.out.println(" Znalazlem pierwszy znak");
			}
			if (entry.getKey().getSymbol().toString() == "^"){
				System.out.println(" Znalazlem pierwszy znak - w zlym miejscu");
			}
		}
	}

}

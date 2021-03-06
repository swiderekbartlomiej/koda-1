package com.koda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Translator {
	
	/**
	 * PRZESTARZAŁA. Uzywać translateSC_New
	 * Tłumaczy ArrayList symboli wejściowych na wyjściowy ArrayList słów kodowych, dla metody SingleCharacter
	 * @param disctionaryHashMap HashMapa słownika
	 * @param inputList ArrayList symboli wejściowych
	 * @return ArrayList przetłumaczonych na kod symboli wejściowych
	 */
	public static ArrayList translateSC(HashMap<SingleCharacter, BinaryBox> disctionaryHashMap, ArrayList<SingleCharacter> inputList){
		System.out.println("FUNKCJA PRZESTARZAŁA. Uzywać translateSC_New");
		ArrayList<String> codedInputList = new ArrayList();
		String inputWord;
		int codeWordSumSize = new Integer(0);
		for (SingleCharacter inputSC : inputList){
			inputWord = inputSC.getValue();
			for (Map.Entry<SingleCharacter, BinaryBox> entry : disctionaryHashMap.entrySet()){
				if (inputWord.equals(entry.getKey().getSymbol().toString())){
					//System.out.println("Symbol: "+inputWord+" kod:"+entry.getValue().getValue()+" binarnie: "+Integer.toString(entry.getValue().getValue(),2)+" rozmiar:"+(32-entry.getValue().returnFreeSpace()));
					codedInputList.add(leftPad(Integer.toString(entry.getValue().getValue(),2),32-entry.getValue().returnFreeSpace()-Integer.toString(entry.getValue().getValue(),2).length(),"0"));
					codeWordSumSize+=(32-entry.getValue().returnFreeSpace());
					break;
				}
			}
		}
		System.out.println("Średnia długość bitowa słowa wyjściowego: "+(float)codeWordSumSize/codedInputList.size()+" ("+codedInputList.size()+" słów kodowych)");
		return codedInputList;
	}
	
	/**
	 * Tłumaczy ArrayList symboli wejściowych na wyjściowy ArrayList słów kodowych, dla metody SingleCharacter
	 * @param disctionaryHashMap HashMapa słownika
	 * @param inputList ArrayList symboli wejściowych
	 * @return ArrayList przetłumaczonych na kod symboli wejściowych
	 */
	public static ArrayList<String> translateSC_New(HashMap<SingleCharacter, BinaryBox> disctionaryHashMap, ArrayList<SingleCharacter> inputList){
		ArrayList<String> codedInputList = new ArrayList<String>();
		BinaryBox actualBinaryBox;
		int codeWordSumSize = new Integer(0);
		for (SingleCharacter inputSC : inputList){
			actualBinaryBox = disctionaryHashMap.get(inputSC);
			//System.out.println("Symbol: "+inputSC.getValue()+" kod: "+actualBinaryBox.getValue()+" binarnie: "+Integer.toString(actualBinaryBox.getValue(),2)+" rozmiar:"+(32-actualBinaryBox.returnFreeSpace()));
			codedInputList.add(leftPad(Integer.toString(actualBinaryBox.getValue(),2),32-actualBinaryBox.returnFreeSpace()-Integer.toString(actualBinaryBox.getValue(),2).length(),"0"));
			codeWordSumSize+=(32-actualBinaryBox.returnFreeSpace());
		}
		System.out.println("Średnia długość bitowa słowa wyjściowego: "+(float)codeWordSumSize/codedInputList.size()+" ("+codedInputList.size()+" słów kodowych)");
		return codedInputList;
	}
	
	/**
	 * PRZESTARZAŁA. Uzywać translateTC_New
	 * Tłumaczy ArrayList symboli wejściowych na wyjściowy ArrayList słów kodowych, dla metody TwoCharacters
	 * @param disctionaryHashMap HashMapa słownika
	 * @param inputList ArrayList symboli wejściowych
	 * @return ArrayList przetłumaczonych na kod symboli wejściowych
	 */
	public static ArrayList<String> translateTC(HashMap<TwoCharacters, BinaryBox> disctionaryHashMap, ArrayList<TwoCharacters> inputList){
		System.out.println("FUNKCJA PRZESTARZAŁA. Uzywać translateTC_New");
		ArrayList<String> codedInputList = new ArrayList<String>();
		String inputWord;
		int codeWordSumSize = new Integer(0);
		for (TwoCharacters inputTC : inputList){
			inputWord = inputTC.getValue();
			for (Map.Entry<TwoCharacters, BinaryBox> entry : disctionaryHashMap.entrySet()){
				if (inputWord.charAt(0)==entry.getKey().getCharacters()[0] &&  inputWord.charAt(1)==entry.getKey().getCharacters()[1]){
					codedInputList.add(leftPad(Integer.toString(entry.getValue().getValue(),2),32-entry.getValue().returnFreeSpace()-Integer.toString(entry.getValue().getValue(),2).length(),"0"));
					//System.out.println("Symbol: "+inputWord+" kod:"+entry.getValue().getValue()+" binarnie: "+Integer.toString(entry.getValue().getValue(),2)+" rozmiar:"+(32-entry.getValue().returnFreeSpace()));
					codeWordSumSize+=(32-entry.getValue().returnFreeSpace());
					break;
				}
			}
		}
		System.out.println("Średnia długość bitowa słowa wyjściowego: "+(float)codeWordSumSize/codedInputList.size()+" ("+codedInputList.size()+" słów kodowych)");
		return codedInputList;
	}
	
	/**
	 * Tłumaczy ArrayList symboli wejściowych na wyjściowy ArrayList słów kodowych, dla metody TwoCharacters
	 * @param disctionaryHashMap HashMapa słownika
	 * @param inputList ArrayList symboli wejściowych
	 * @return ArrayList przetłumaczonych na kod symboli wejściowych
	 */
	public static ArrayList<String> translateTC_New(HashMap<TwoCharacters, BinaryBox> disctionaryHashMap, ArrayList<TwoCharacters> inputList){
		ArrayList<String> codedInputList = new ArrayList<String>();
		BinaryBox actualBinaryBox;
		int codeWordSumSize = new Integer(0);
		for (TwoCharacters inputTC : inputList){
			actualBinaryBox = disctionaryHashMap.get(inputTC);
			codedInputList.add(leftPad(Integer.toString(actualBinaryBox.getValue(),2),32-actualBinaryBox.returnFreeSpace()-Integer.toString(actualBinaryBox.getValue(),2).length(),"0"));
			codeWordSumSize+=(32-actualBinaryBox.returnFreeSpace());
			//System.out.println("Dopasowałem do znaku "+inputTC.getValue()+" wartosc słowa "+actualBinaryBox.getValue()+" hasz: "+inputTC.getValue().hashCode());			
		}
		System.out.println("Średnia długość bitowa słowa wyjściowego: "+(float)codeWordSumSize/codedInputList.size()+" ("+codedInputList.size()+" słów kodowych)");
		return codedInputList;
	}
	/**
	 * PRZESTARZAŁA. Uzywać translateCC_New
	 * Tłumaczy ArrayList symboli wejściowych na wyjściowy ArrayList słów kodowych, dla metody ContextCharacter
	 * @param disctionaryHashMap HashMapa słownika
	 * @param inputList ArrayList symboli wejściowych
	 * @return ArrayList przetłumaczonych na kod symboli wejściowych
	 */
	public static ArrayList<String> translateCC(HashMap<ContextCharacter, BinaryBox> disctionaryHashMap, ArrayList<ContextCharacter> inputList){
		ArrayList<String> codedInputList = new ArrayList<String>();
		String inputWord;
		int codeWordSumSize = new Integer(0);
		for (ContextCharacter inputCC : inputList){
			inputWord = inputCC.getValue();
			for (Map.Entry<ContextCharacter, BinaryBox> entry : disctionaryHashMap.entrySet()){
				if (inputWord.charAt(1)==entry.getKey().getCharacters()[1] &&  inputWord.charAt(0)==entry.getKey().getCharacters()[0]){
					codedInputList.add(leftPad(Integer.toString(entry.getValue().getValue(),2),32-entry.getValue().returnFreeSpace()-Integer.toString(entry.getValue().getValue(),2).length(),"0"));
					//System.out.println("Symbol: "+inputWord+" kod:"+entry.getValue().getValue()+" binarnie: "+Integer.toString(entry.getValue().getValue(),2)+" rozmiar:"+(32-entry.getValue().returnFreeSpace()));
					codeWordSumSize+=(32-entry.getValue().returnFreeSpace());
					break;
				}
			}
		}
		System.out.println("Średnia długość bitowa słowa wyjściowego: "+(float)codeWordSumSize/codedInputList.size()+" ("+codedInputList.size()+" słów kodowych)");
		return codedInputList;
	}
	
	/**
	 * Tłumaczy ArrayList symboli wejściowych na wyjściowy ArrayList słów kodowych, dla metody ContextCharacter
	 * @param disctionaryHashMap HashMapa słownika
	 * @param inputList ArrayList symboli wejściowych
	 * @return ArrayList przetłumaczonych na kod symboli wejściowych
	 */
	public static ArrayList<String> translateCC_New(HashMap<ContextCharacter, BinaryBox> disctionaryHashMap, ArrayList<ContextCharacter> inputList){
		ArrayList<String> codedInputList = new ArrayList<String>();
		BinaryBox actualBinaryBox;
		int codeWordSumSize = new Integer(0);
		for (ContextCharacter inputCC : inputList){
			actualBinaryBox = disctionaryHashMap.get(inputCC);
			codedInputList.add(leftPad(Integer.toString(actualBinaryBox.getValue(),2),32-actualBinaryBox.returnFreeSpace()-Integer.toString(actualBinaryBox.getValue(),2).length(),"0"));
			codeWordSumSize+=(32-actualBinaryBox.returnFreeSpace());
			//System.out.println("Dopasowałem do znaku "+inputCC.getValue()+" wartosc słowa "+actualBinaryBox.getValue()+" hasz: "+inputCC.getValue().hashCode());
		}
		System.out.println("Średnia długość bitowa słowa wyjściowego: "+(float)codeWordSumSize/codedInputList.size()+" ("+codedInputList.size()+" słów kodowych)");
		return codedInputList;
	}
	
	private static String leftPad (String binaryCode, int leftpadcount, String padChar){
		String leftPaddedString=binaryCode;
		for (int i=0; i<leftpadcount; i++){
			leftPaddedString=padChar+leftPaddedString;
		}
		return leftPaddedString;
	}

}

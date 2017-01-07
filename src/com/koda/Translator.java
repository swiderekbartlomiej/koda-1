package com.koda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Translator {
	
	/**
	 * Tłumaczy ArrayList symboli wejściowych na wyjściowy ArrayList słów kodowych, dla metody SingleCharacter
	 * @param disctionaryHashMap HashMapa słownika
	 * @param inputList ArrayList symboli wejściowych
	 * @return ArrayList przetłumaczonych na kod symboli wejściowych
	 */
	public static ArrayList translateSC(HashMap<SingleCharacter, BinaryBox> disctionaryHashMap, ArrayList<SingleCharacter> inputList){
		ArrayList<String> codedInputList = new ArrayList();
		String inputWord;
		int codeWordSumSize = new Integer(0);
		for (SingleCharacter inputSC : inputList){
			inputWord = inputSC.getValue();
			for (Map.Entry<SingleCharacter, BinaryBox> entry : disctionaryHashMap.entrySet()){
				if (inputWord.equals(entry.getKey().getSymbol().toString())){
					System.out.println("Symbol: "+inputWord+" kod:"+entry.getValue().getValue()+" binarnie: "+Integer.toString(entry.getValue().getValue(),2)+" rozmiar:"+(32-entry.getValue().returnFreeSpace()));
					codedInputList.add(leftPad(Integer.toString(entry.getValue().getValue(),2),32-entry.getValue().returnFreeSpace()-Integer.toString(entry.getValue().getValue(),2).length(),"0"));
					codeWordSumSize+=(32-entry.getValue().returnFreeSpace());
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
	public static ArrayList translateTC(HashMap<TwoCharacters, BinaryBox> disctionaryHashMap, ArrayList<String> inputList){
		ArrayList<String> codedInputList = new ArrayList();
		int codeWordSumSize = new Integer(0);
		for (String inputWord : inputList){
			for (Map.Entry<TwoCharacters, BinaryBox> entry : disctionaryHashMap.entrySet()){
				if (inputWord.charAt(0)==entry.getKey().getCharacters()[0] &&  inputWord.charAt(1)==entry.getKey().getCharacters()[1]){
					codedInputList.add(leftPad(Integer.toString(entry.getValue().getValue(),2),32-entry.getValue().returnFreeSpace()-Integer.toString(entry.getValue().getValue(),2).length(),"0"));
					System.out.println("Symbol: "+inputWord+" kod:"+entry.getValue().getValue()+" binarnie: "+Integer.toString(entry.getValue().getValue(),2)+" rozmiar:"+(32-entry.getValue().returnFreeSpace()));
					codeWordSumSize+=(32-entry.getValue().returnFreeSpace());
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
	public static ArrayList translateCC(HashMap<ContextCharacter, BinaryBox> disctionaryHashMap, ArrayList<String> inputList){
		ArrayList<String> codedInputList = new ArrayList();
		int codeWordSumSize = new Integer(0);
		for (String inputWord : inputList){
			for (Map.Entry<ContextCharacter, BinaryBox> entry : disctionaryHashMap.entrySet()){
				if (inputWord.charAt(0)==entry.getKey().getCharacters()[1] &&  inputWord.charAt(1)==entry.getKey().getCharacters()[0]){
					codedInputList.add(leftPad(Integer.toString(entry.getValue().getValue(),2),32-entry.getValue().returnFreeSpace()-Integer.toString(entry.getValue().getValue(),2).length(),"0"));
					System.out.println("Symbol: "+inputWord+" kod:"+entry.getValue().getValue()+" binarnie: "+Integer.toString(entry.getValue().getValue(),2)+" rozmiar:"+(32-entry.getValue().returnFreeSpace()));
					codeWordSumSize+=(32-entry.getValue().returnFreeSpace());
				}
			}
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

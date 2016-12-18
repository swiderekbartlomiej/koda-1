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
	public static ArrayList translateSC(HashMap<SingleCharacter, Integer> disctionaryHashMap, ArrayList<String> inputList){
		ArrayList<Integer> codedInputList = new ArrayList();
		
		for (String inputWord : inputList){
			for (Map.Entry<SingleCharacter, Integer> entry : disctionaryHashMap.entrySet()){
				if (inputWord.equals(entry.getKey().getSymbol().toString())){
					codedInputList.add(entry.getValue());
				}
			}
		}
		return codedInputList;
	}
	
	/**
	 * Tłumaczy ArrayList symboli wejściowych na wyjściowy ArrayList słów kodowych, dla metody TwoCharacters
	 * @param disctionaryHashMap HashMapa słownika
	 * @param inputList ArrayList symboli wejściowych
	 * @return ArrayList przetłumaczonych na kod symboli wejściowych
	 */
	public static ArrayList translateTC(HashMap<TwoCharacters, Integer> disctionaryHashMap, ArrayList<String> inputList){
		ArrayList<Integer> codedInputList = new ArrayList();
		
		for (String inputWord : inputList){
			for (Map.Entry<TwoCharacters, Integer> entry : disctionaryHashMap.entrySet()){
				if (inputWord.charAt(0)==entry.getKey().getCharacters()[0] &&  inputWord.charAt(1)==entry.getKey().getCharacters()[1]){
					codedInputList.add(entry.getValue());
				}
			}
		}
		for (int x: codedInputList){
			System.out.println(Integer.toString(x));
		}
		return codedInputList;
	}
	/**
	 * Tłumaczy ArrayList symboli wejściowych na wyjściowy ArrayList słów kodowych, dla metody ContextCharacter
	 * @param disctionaryHashMap HashMapa słownika
	 * @param inputList ArrayList symboli wejściowych
	 * @return ArrayList przetłumaczonych na kod symboli wejściowych
	 */
	public static ArrayList translateCC(HashMap<ContextCharacter, Integer> disctionaryHashMap, ArrayList<String> inputList){
		ArrayList<Integer> codedInputList = new ArrayList();
		
		for (String inputWord : inputList){
			for (Map.Entry<ContextCharacter, Integer> entry : disctionaryHashMap.entrySet()){
				if (inputWord.charAt(0)==entry.getKey().getCharacters()[1] &&  inputWord.charAt(1)==entry.getKey().getCharacters()[0]){
					codedInputList.add(entry.getValue());
				}
			}
		}
		return codedInputList;
	}

}

// Klasa InputRead
// Czyta dane z pliku wejściowego stworzonego przez generator

package com.koda;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class InputReader {
	
	// Sciezka do pliku z danymi wejsciowymi
	String path;
	
	// lista elementów odczytanych z pliku wejściowego
	private List<String> inputList = new ArrayList<>();
	
	// mapa znak-liczba wystapien
	private HashMap<String, Integer> statisticMap = new HashMap<String, Integer>();
	
	//Struktury które bedziemy zwracac w zaleznosci od opcji dzialania
	private ArrayList<SingleCharacter> listSingleCharacter = new ArrayList();
	private ArrayList<TwoCharacters> listTwoCharacters = new ArrayList();
	private ArrayList<ContextCharacter> listContextCharacter = new ArrayList();
	
	public InputReader (String path){
		this.path=path;
	}
	
	// czyta plik wejsciowy dla metody SingleCharacter, generujac przy tym statystykę
	public ArrayList<SingleCharacter> readToSingleCharacter (){
		try {
			statisticMap = new HashMap<String, Integer>(); //zerowanie mapy statystyk
			Scanner scanner =  new Scanner ( new BufferedReader ( new FileReader(this.path)));
			scanner.useDelimiter("");
			while (scanner.hasNext())
			{
				String nextChar = scanner.next();
				inputList.add(nextChar);
				if (!statisticMap.containsKey(nextChar)){
					statisticMap.put(nextChar, 1);
				}
				else{
					statisticMap.put(nextChar, statisticMap.get(nextChar)+1);
				}
			}
			for (int i=0; i<inputList.size(); i++){
				listSingleCharacter.add(new SingleCharacter(inputList.get(i).charAt(0), statisticMap.get(inputList.get(i))));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return listSingleCharacter;
	}
	// czyta plik wejsciowy dla metody TwoCharacters, generujac przy tym statystykę
	public ArrayList<TwoCharacters> readToTwoCharacters (){
		try {
			statisticMap = new HashMap<String, Integer>(); //zerowanie mapy statystyk
			Scanner scanner =  new Scanner ( new BufferedReader ( new FileReader(this.path)));
			scanner.useDelimiter("");
			while (scanner.hasNext())
			{
				String nextChar = scanner.next()+scanner.next();
				inputList.add(nextChar);
				//System.out.println(nextChar);
				if (!statisticMap.containsKey(nextChar)){
					statisticMap.put(nextChar, 1);
				}
				else{
					statisticMap.put(nextChar, statisticMap.get(nextChar)+1);
				}
			}
			for (int i=0; i<inputList.size(); i++){
				listTwoCharacters.add(new TwoCharacters(inputList.get(i).charAt(0),inputList.get(i).charAt(1), statisticMap.get(inputList.get(i))));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return listTwoCharacters;
	}
	
	// czyta plik wejsciowy dla metody ContextCharacter, generujac przy tym statystykę
	public ArrayList<ContextCharacter> readToContextCharacter(){
		try {
			statisticMap = new HashMap<String, Integer>(); // zerowanie mapy statystyk
			Scanner scanner =  new Scanner ( new BufferedReader ( new FileReader(this.path)));
			scanner.useDelimiter("");
			String firstChar="^"; // W MIŁOŚCI DO BASHA TAK ZOSTAŁEM WYCHOWANY!
			String actualChar=scanner.next();
			String contextChar=firstChar;
			String firstPair = contextChar+actualChar;
			inputList.add(firstPair);
			statisticMap.put(firstPair, 1);
			while (scanner.hasNext())
			{
				contextChar = actualChar;
				actualChar = scanner.next();
				String nextChar = contextChar+actualChar;
				inputList.add(nextChar);
				//System.out.println(nextChar);
				if (!statisticMap.containsKey(nextChar)){
					statisticMap.put(nextChar, 1);
				}
				else{
					statisticMap.put(nextChar, statisticMap.get(nextChar)+1);
				}
			}
			for (int i=0; i<inputList.size(); i++){
				listContextCharacter.add(new ContextCharacter(inputList.get(i).charAt(1),inputList.get(i).charAt(0), statisticMap.get(inputList.get(i))));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return listContextCharacter;
	}
	
	// Drukuje zawartość listy z SingleCharacter
	public void printListSingleCharacter(List<SingleCharacter> list){
		for (int i=0; i<list.size(); i++){
			list.get(i).print();
		}
	}
	
	public ArrayList<SingleCharacter> getListSingleCharacter (){
		return listSingleCharacter;
	}
	
	public ArrayList<TwoCharacters> getlistTwoCharacters (){
		return listTwoCharacters;
	}
	
	public ArrayList<ContextCharacter> getlistContextCharacter (){
		return listContextCharacter;
	}
	
	// Drukuje zawartość listy z TwoCharacters
	public void printListTwoCharacters(List<TwoCharacters> list){
		for (int i=0; i<list.size(); i++){
			list.get(i).print();
		}
	}
	
	// Drukuje zawartość listy z ContextChar
	public void printListContextCharacter(List<ContextCharacter> list){
		for (int i=0; i<list.size(); i++){
			list.get(i).print();
		}
	}
	
	// Zwraca mapę ze statystykami dla SingleCHaracter
	public ArrayList<SingleCharacter> returnStatisticHashMapSC (){
		ArrayList<SingleCharacter> arrayListStatisticMap = new ArrayList();
		for (Map.Entry<String, Integer> entry : statisticMap.entrySet()){
			arrayListStatisticMap.add(new SingleCharacter(entry.getKey().toCharArray()[0], entry.getValue()));
			//System.out.println(entry.getKey().toCharArray()[0]+" "+entry.getValue());
		}
		return arrayListStatisticMap;
	}
	
	// Zwraca mapę ze statystykami dla TwoCharacters
	public ArrayList<TwoCharacters> returnStatisticHashMapTC (){
		ArrayList<TwoCharacters> arrayListStatisticMap = new ArrayList();
		for (Map.Entry<String, Integer> entry : statisticMap.entrySet()){
			arrayListStatisticMap.add(new TwoCharacters(entry.getKey().toCharArray()[0],entry.getKey().toCharArray()[1], entry.getValue()));
		}
		return arrayListStatisticMap;
	}
	
	// Zwraca mapę ze statystykami dla ContextCharacter
	public ArrayList<ContextCharacter> returnStatisticHashMapCC (){
		ArrayList<ContextCharacter> arrayListStatisticMap = new ArrayList();
		for (Map.Entry<String, Integer> entry : statisticMap.entrySet()){
			arrayListStatisticMap.add(new ContextCharacter(entry.getKey().toCharArray()[1],entry.getKey().toCharArray()[0], entry.getValue()));
//			System.out.println(entry.getKey().toCharArray()[1]+"  "+entry.getKey().toCharArray()[0]+"  "+entry.getValue());
		}
		return arrayListStatisticMap;
	}
	
	// Zwraca listę elementow wejsciowych
	public List<String> returnInputList (){
		return inputList;
	}
	
	// Drukuje mape statystyki
	public void printStatisticHashMap(){
		System.out.println("Mapa symbol=ilośc_wystapien :");
		System.out.println(Arrays.asList(statisticMap));
		System.out.println("Rozmiar: "+statisticMap.size());
	}

}
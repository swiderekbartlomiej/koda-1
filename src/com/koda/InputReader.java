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
import java.util.Scanner;

public class InputReader {
	
	// lista elementów odczytanych z pliku wejściowego
	private ArrayList<String> inputList;
	
	// mapa znak-liczba wystapien
	private HashMap<String, Integer> statisticMap = new HashMap<String, Integer>();
	
	public InputReader ()
	{
		inputList = new ArrayList<>();
	}
	
	// czyta plik wejsciowy, generujac przy tym statystykę
	public void readFromFile (String path){
		try {
			Scanner scanner =  new Scanner ( new BufferedReader ( new FileReader(path)));
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
			scanner.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// Zwraca mapę ze statystykami
	public HashMap<String, Integer> returnStatisticHashMap (){
		return statisticMap;
	}
	
	// Zwraca listę elementow wejsciowych
	public List<String> returnInputList (){
		return inputList;
	}
	
	// Drukuje mape statystyki
	public void printStatisticHashMap(){
		System.out.println(Arrays.asList(statisticMap));
	}

}

// Klasa InputRead
// Czyta dane z pliku wejściowego stworzonego przez generator

package com.koda;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry.Entry;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class InputReader {
	
	// Sciezka do pliku z danymi wejsciowymi
	String path;
	
	// lista elementów odczytanych z pliku wejściowego
	private List<String> inputList = new ArrayList<>();
	
	// mapa znak-liczba wystapien
	private HashMap<String, Integer> statisticMap = new HashMap<String, Integer>();
	
	// mapa znak-prawdopodobienstwo
	private HashMap<String, Integer> probabilityMap = new HashMap<String, Integer>();
	
	//Struktury które bedziemy zwracac w zaleznosci od opcji dzialania
	private ArrayList<SingleCharacter> listSingleCharacter = new ArrayList();
	private ArrayList<TwoCharacters> listTwoCharacters = new ArrayList();
	private ArrayList<ContextCharacter> listContextCharacter = new ArrayList();
	
	public InputReader (String path) throws IOException{
		if (Pattern.matches(".*\\.txt$", path)){
			this.path=path;
		}
		else{
			this.path=path.replaceAll("\\.png$", "_tmp\\.txt");
			translateImageToString (path);
		}
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
			// liczenie entropii dla symboli wejściowych
			//System.out.println("Ilość słów kodowych odczytanych z wejścia: " + inputList.size());
			System.out.println("Entropia danych wejściowych: " + (float)computeEntropy(computeProbability(statisticMap, inputList.size())));

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
				String nextChar = scanner.next();
				if (scanner.hasNext()){
					nextChar+=scanner.next();
				}else{
					nextChar+=" ";
				}
				inputList.add(nextChar);
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
			// liczenie entropii dla symboli wejściowych
			//System.out.println("Ilość słów kodowych odczytanych z wejścia: " + inputList.size());
			System.out.println("Entropia danych wejściowych: " + (float)computeEntropy(computeProbability(statisticMap, inputList.size())));

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
			// liczenie entropii dla symboli wejściowych
			//System.out.println("Ilość słów kodowych odczytanych z wejścia: " + inputList.size());
			System.out.println("Entropia danych wejściowych: " + (float)computeEntropy(computeProbability(statisticMap, inputList.size())));

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
	
	private void translateImageToString (String path) throws IOException{
		ByteArrayOutputStream baos=new ByteArrayOutputStream(10000);
		BufferedImage img = ImageIO.read(new File(path));
		ImageIO.write(img, "png", baos);
		baos.flush();
		String base64String=Base64.encode(baos.toByteArray());
		baos.close();
		byte[] bytearray = Base64.decode(base64String);
		PrintWriter imageTextOut = new PrintWriter(this.path);
		for (int i=0;i<bytearray.length; i++){
			char byteAsChar = (char)(bytearray[i] & 0xFF);
			imageTextOut.write(byteAsChar);
		}
		imageTextOut.close();
	}
	
	// Liczy p-stwo wystąpienia poszczególnych znaków - zwraca hashmape [znak, p-stwo]
	private HashMap<String, Double> computeProbability(HashMap<String, Integer> statisticMap, Integer numberOfElements){
		HashMap<String, Double> probabilityMap = new HashMap<String, Double>();
		//double sumProbability = 0;
		for(Map.Entry<String, Integer> entry : statisticMap.entrySet()){
			probabilityMap.put(entry.getKey(), entry.getValue().doubleValue()/numberOfElements.doubleValue());
			//System.out.println(entry.getKey().toString() + " : " + entry.getValue().toString());// + " : " + entry.getValue().doubleValue()/numberOfElements.doubleValue());
			//sumProbability += entry.getValue().doubleValue()/numberOfElements.doubleValue();
		}
		//System.out.println(sumProbability);
		return probabilityMap;
	}
	
	// Liczy entropię dla danych wejściowych przyjmując na wejsciu hashmape [znak, p-stwo]
	private double computeEntropy(HashMap<String, Double> probabilityMap){
		double entropy = 0;
		for(Map.Entry<String, Double> entry : probabilityMap.entrySet()){
			entropy += entry.getValue().doubleValue() * log2(entry.getValue().doubleValue());
		}
		return Math.abs(entropy);
	}
	
	// Logarytm przy podstawi 2 - chyba wiadomo o co kam
	private double log2(double value){
		return Math.log10(value)/Math.log10(2.0);
	}
}
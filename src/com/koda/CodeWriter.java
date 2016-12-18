package com.koda;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Klasa obsługująca zapis zakodowanego tekstu do pliku.
 * @author koda
 *
 */
public class CodeWriter {
	
	//Do tej listy buduje BinaryBox'y wypełnione kodem
	private List<Integer> outputlistOfIntMagazines = new ArrayList<>();
	

	/**
	 * Przyjmuje od tłumacza ArrayListe syboli w zakodowanej postaci, i zapisuje je nieredundantnie do pliku.
	 * @param listOfCodeWords lista zakodowanych symboli, podawana przez tłumacza
	 */
	public void saveCodeToFile(ArrayList listOfCodeWords){
		
		BinaryBox actualBox = new BinaryBox();
		int partA;
		int partB;
		int partBMask;
		
		for (Object codeWord : listOfCodeWords){
			int intCodeWord = (int)codeWord;
			if (actualBox.returnFreeSpace() >= calcSignificantBits(intCodeWord)){
				actualBox.shiftLeft(calcSignificantBits(intCodeWord));
				actualBox.appendValue(intCodeWord);
				actualBox.increaseSpaceUsed(calcSignificantBits(intCodeWord));
			}else if (actualBox.returnFreeSpace() > 0){
				int shitfValue = calcSignificantBits(intCodeWord)-actualBox.returnFreeSpace();
				partA = intCodeWord >> shitfValue;
				actualBox.shiftLeft(calcSignificantBits(partA));
				actualBox.appendValue(partA);
				actualBox.increaseSpaceUsed(calcSignificantBits(partA));
				
				outputlistOfIntMagazines.add(actualBox.getValue());
				
				actualBox = new BinaryBox();

				partBMask = (int) Math.pow(2, shitfValue)-1;
				partB = intCodeWord&partBMask;
				
				actualBox.appendValue(partB);
				actualBox.increaseSpaceUsed(shitfValue);
				
			}else{
				outputlistOfIntMagazines.add(actualBox.getValue());
				actualBox = new BinaryBox();
				actualBox.shiftLeft(calcSignificantBits(intCodeWord));
				actualBox.increaseSpaceUsed(calcSignificantBits(intCodeWord));
				actualBox.appendValue(intCodeWord);
			}
		}
			actualBox.forceCloseBox();
			outputlistOfIntMagazines.add(actualBox.getValue());
		
		
		try {
			DataOutputStream out = new DataOutputStream(new FileOutputStream("/home/koda/gen-bin2"));
			for (int x : this.outputlistOfIntMagazines){
				out.writeInt(x);
			}
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	/**
	 * Ta metoda jest stara, napisana w złym stylu. Używajcie saveCodeToFile()
	 * @param listOfCodeWords lista zakodowanych symboli, podawana przez tłumacza
	 */
	private void codeBuilder(ArrayList listOfCodeWords){
		
		int actualMagazine=0;
		int spaceUsedInActualMagazine=0;
		int partA = 0;
		int partB = 0;
		
		for (Object codeWord : listOfCodeWords){
			
			int intCodeWord = (int)codeWord;
			System.out.println("Biere znak "+intCodeWord);
			if (32-spaceUsedInActualMagazine >= calcSignificantBits(intCodeWord)){
				actualMagazine = actualMagazine << calcSignificantBits(intCodeWord);
				System.out.println("przesunalem magazyn o "+calcSignificantBits(intCodeWord));
				actualMagazine = actualMagazine | intCodeWord;
				spaceUsedInActualMagazine+=calcSignificantBits(intCodeWord);
				
			}else if (32-spaceUsedInActualMagazine > 0){
				System.out.println("Dodaje dzielac");
				System.out.println("oryginalna cyferka "+intCodeWord);
				System.out.println("oryginalna cyferka "+Integer.toString(intCodeWord,2));
				int shitfValue = calcSignificantBits(intCodeWord)-32+spaceUsedInActualMagazine;
				partA = intCodeWord >> shitfValue;
				actualMagazine = actualMagazine << calcSignificantBits(partA);
				actualMagazine = actualMagazine | partA;
				spaceUsedInActualMagazine += calcSignificantBits(partA);
				
				outputlistOfIntMagazines.add(actualMagazine);
				actualMagazine = 0;
				spaceUsedInActualMagazine=0;
				
				int partBMask = (int) Math.pow(2, shitfValue)-1;
				partB = intCodeWord&partBMask;
				System.out.println("Nie przesuwamy magazynu bo nie trzeba");
				
				actualMagazine = actualMagazine | partB;
				
				spaceUsedInActualMagazine += shitfValue;
			}else{
				outputlistOfIntMagazines.add(actualMagazine);
				actualMagazine = 0;
				spaceUsedInActualMagazine=0;
				
				actualMagazine = actualMagazine << calcSignificantBits(intCodeWord);
				spaceUsedInActualMagazine+=calcSignificantBits(intCodeWord);
				actualMagazine = actualMagazine ^ intCodeWord;
			}
		}
		actualMagazine = actualMagazine << (32-spaceUsedInActualMagazine);
		outputlistOfIntMagazines.add(actualMagazine);
		
		
		try {
			DataOutputStream out = new DataOutputStream(new FileOutputStream("/home/koda/gen-bin2"));
			for (int x : this.outputlistOfIntMagazines){
				out.writeInt(x);
			}
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * Liczy ile dany integer ma bitów znaczących w postaci binarnej
	 * @param intWordRep integer
	 * @return zwraca liczbę bitów znaczących
	 */
	private int calcSignificantBits (int intWordRep){
		
		for (int i=1; i<=32; i++){
			if (intWordRep < Math.pow(2,i) & intWordRep >= Math.pow(2,i-1)){
				return i;
			}else if (intWordRep==0)
			{
				return 1;
			}
		}
		return 0;
	}
	
}
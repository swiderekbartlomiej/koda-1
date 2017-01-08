package com.koda;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;


//import org.opencv.core.Core;
//import org.opencv.core.CvType;
//import org.opencv.core.Mat;

public class App {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 //System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
	     //Mat mat = Mat.eye( 3, 3, CvType.CV_8UC1 );
	     //System.out.println( "mat = " + mat.dump() );
	     
	     System.out.println("KOOOOOOOODAAAAA!");
	     
//	     InputReader ourReader = new InputReader("/home/koda/gen.txt");
	     // Poniżej wydruki ze wszystkich trzech metod, jako przykład.
//	     ourReader.printListSingleCharacter(ourReader.readToSingleCharacter());
//	     ourReader.printListTwoCharacters(ourReader.readToTwoCharacters());
//	     ourReader.printListContextCharacter(ourReader.readToContextCharacter());
     
	    // Poniżej przykład użycia zapisu do pliku binarnego, na randomowych danych. Docelowo będzie dostarczał je tłumacz.
//	    CodeWriter cw = new CodeWriter();
//	    ArrayList<Integer> al = new ArrayList<>();
//	    al.add(175);
//	    al.add(268);
//	    al.add(252);
//	    al.add(469);
//	    al.add(1024);
//	    al.add(777);
//	    cw.saveCodeToFile(al);
	    
	 // TEST DLA SINGLE CHARACTER #####################################################
	     

//	     ArrayList<SingleCharacter> test_alphabet = new ArrayList<>();
//	     test_alphabet.add(new SingleCharacter('a', 10));
//	     test_alphabet.add(new SingleCharacter('b', 14));
//	     test_alphabet.add(new SingleCharacter('c', 5));
//	     test_alphabet.add(new SingleCharacter('d', 20));
//	     test_alphabet.add(new SingleCharacter('l', 24));
//	     test_alphabet.add(new SingleCharacter('g', 7));
//	     test_alphabet.add(new SingleCharacter('z', 15));
//	     test_alphabet.add(new SingleCharacter('y', 16));
//	     test_alphabet.add(new SingleCharacter('x', 23));
//	     test_alphabet.add(new SingleCharacter('o', 12));
//	     test_alphabet.add(new SingleCharacter('p', 19));
//	     test_alphabet.add(new SingleCharacter('s', 9));
//	     
//	     HuffmanTree<SingleCharacter> huff_tree = new HuffmanTree<>(test_alphabet);
//	     HashMap<SingleCharacter, BinaryBox> codes = huff_tree.getCodeDictionary();
//	     
//	     for (Map.Entry<SingleCharacter, BinaryBox> entry : codes.entrySet())
//	     {
//	    	 System.out.println("Char: " + entry.getKey().getSymbol() + " Code:" + entry.getValue().getValue() + " Space:" + entry.getValue().returnFreeSpace());
//	     }
	    
//	    ArrayList<TwoCharacters> test_alphabet = new ArrayList<>();
//	    test_alphabet.add(new TwoCharacters('A', 'A', 12));
//	    test_alphabet.add(new TwoCharacters('A', 'B', 3));
//	    test_alphabet.add(new TwoCharacters('A', 'C', 6));
//	    test_alphabet.add(new TwoCharacters('B', 'A', 7));
//	    test_alphabet.add(new TwoCharacters('B', 'B', 8));
//	    test_alphabet.add(new TwoCharacters('B', 'C', 2));
//	    test_alphabet.add(new TwoCharacters('C', 'A', 5));
//	    test_alphabet.add(new TwoCharacters('C', 'B', 9));
//	    test_alphabet.add(new TwoCharacters('C', 'C', 10));
//	    
//	    HuffmanTree<TwoCharacters> huff_tree = new HuffmanTree<>(test_alphabet);
//	    HashMap<TwoCharacters, BinaryBox> codes = huff_tree.getCodeDictionary();
//	    
//	    for (Map.Entry<TwoCharacters, BinaryBox> entry : codes.entrySet())
//		{
//	    	System.out.println("Char: " + entry.getKey().getFirst() + entry.getKey().getSecond() + " Code:" + entry.getValue().getValue() + " Space:" + entry.getValue().returnFreeSpace());
//		}
	     
//	     V2 PRAWDZIWY POCZĄTEK TESTU DLA SINGLE CHARACTER
//	     
//	     ArrayList<SingleCharacter> test_alphabet = new ArrayList<>();
//	     test_alphabet.add(new SingleCharacter('a', 10));
//	     test_alphabet.add(new SingleCharacter('b', 14));
//	     test_alphabet.add(new SingleCharacter('c', 5));
//	     test_alphabet.add(new SingleCharacter('d', 20));
//	     test_alphabet.add(new SingleCharacter('l', 24));
//	     test_alphabet.add(new SingleCharacter('g', 7));
//	     test_alphabet.add(new SingleCharacter('z', 15));
//	     test_alphabet.add(new SingleCharacter('y', 16));
//	     test_alphabet.add(new SingleCharacter('x', 23));
//	     test_alphabet.add(new SingleCharacter('o', 12));
//	     test_alphabet.add(new SingleCharacter('p', 19));
//	     test_alphabet.add(new SingleCharacter('s', 9));
//	     
//	     HuffmanTree<SingleCharacter> huff_tree = new HuffmanTree<>(test_alphabet);
//	     HashMap<SingleCharacter, BinaryBox> codes = huff_tree.getCodeDictionary();
//	     
//	     
//	     ArrayList<String> test_input = new ArrayList<>();
//	     test_input.add("a");
//	     test_input.add("b");
//	     test_input.add("c");
//	     test_input.add("d");
//	     test_input.add("e");
//	     test_input.add("l");
//	     test_input.add("g");
//	     test_input.add("z");
//	     test_input.add("y");
//	     test_input.add("x");
//	     test_input.add("o");
//	     test_input.add("p");
//	     test_input.add("s");
//	     
//	     Translator test_translator = new Translator();
//	     ArrayList codesList = test_translator.translateSC(codes, test_input);
//	     
//	     CodeWriter cw = new CodeWriter();
//	     
//	     cw.saveCodeToFile(codesList, codes);
//	     
//		 // KONIEC TESTU DLA DLA SINGLE CHARACTER #####################################################
	     
	     // TEST CAŁOŚCIOWY DLA SINGLE CHARACTER ####################################################
	     
	     InputReader ourReader = new InputReader("/home/koda/gen.txt"); 										//czyta plik wejsciowy
	     ArrayList<SingleCharacter> alphabet_SC = ourReader.readToSingleCharacter(); 							// ładuje plik do struktury SingleCharacter
	     
	     alphabet_SC = ourReader.returnStatisticHashMapSC();
	     
	     HuffmanTree<SingleCharacter> huff_tree_SC = new HuffmanTree<>(alphabet_SC);							//buduje drzewo
	     HashMap<SingleCharacter, BinaryBox> dictionary_SC = huff_tree_SC.getCodeDictionary();					//wyjmuje słownik z drzewa
	     
	     Translator translator_SC = new Translator();															// nowy obiekt translatora
	     ArrayList codesList_SC = translator_SC.translateSC(dictionary_SC, ourReader.getListSingleCharacter());	// zamienia symbole z listy wejściowej na listę słów kodowych
	     
	     CodeWriter cw_SC = new CodeWriter();																	// nowy obiekt zapisywacza do pliku
	     
	     cw_SC.saveCodeToFile(codesList_SC, dictionary_SC);														// zapisuje słowa kodowe do pliku
	     
	     
	     // KONIEC TESTU CAŁOŚCIOWEGO DLA SINGLE CHARACTER ##########################################
	     
//	     // TEST CAŁOŚCIOWY DLA TWO CHARACTERS ####################################################
//	     
//	     InputReader ourReader = new InputReader("/home/koda/gen.txt"); 										//czyta plik wejsciowy
//	     ArrayList<TwoCharacters> alphabet_TC = ourReader.readToTwoCharacters();								// ładuje plik do struktury SingleCharacter
//	     ourReader.printStatisticHashMap();
//	     
//	     alphabet_TC = ourReader.returnStatisticHashMapTC();
//	     
//	     HuffmanTree<TwoCharacters> huff_tree_TC = new HuffmanTree<>(alphabet_TC);								//buduje drzewo
//	     HashMap<TwoCharacters, BinaryBox> dictionary_TC = huff_tree_TC.getCodeDictionary();					//wyjmuje słownik z drzewa
//	     
//	     Translator translator_TC = new Translator();															// nowy obiekt translatora
//	     ArrayList codesList_TC = translator_TC.translateTC(dictionary_TC, ourReader.getlistTwoCharacters());	// zamienia symbole z listy wejściowej na listę słów kodowych
//	     
//	     CodeWriter cw_TC = new CodeWriter();																	// nowy obiekt zapisywacza do pliku
//	     
//	     cw_TC.saveCodeToFile(codesList_TC, dictionary_TC);														// zapisuje słowa kodowe do pliku
//	     
//	     
//	     // KONIEC TESTU CAŁOŚCIOWEGO DLA TWO CHARACTERS ##########################################
	     
//	     // TEST CAŁOŚCIOWY DLA CONTEXT CHARACTER ####################################################
//	     
//	     InputReader ourReader = new InputReader("/home/koda/gen.txt"); 										//czyta plik wejsciowy
//	     ArrayList<ContextCharacter> alphabet_CC = ourReader.readToContextCharacter();							// ładuje plik do struktury SingleCharacter
////	     ourReader.printStatisticHashMap();
//	     
//	     
//	     alphabet_CC = ourReader.returnStatisticHashMapCC();	   
//	     
//	     HuffmanTree<ContextCharacter> huff_tree_CC = new HuffmanTree<>(alphabet_CC);							//buduje drzewo
//	     HashMap<ContextCharacter, BinaryBox> dictionary_CC = huff_tree_CC.getCodeDictionary();					//wyjmuje słownik z drzewa
//	     	     
//	     DictionaryPrinter.printCCDictionary(dictionary_CC);
//	     
//	     Translator translator_CC = new Translator();															// nowy obiekt translatora
//	     ArrayList codesList_CC = translator_CC.translateCC(dictionary_CC, ourReader.getlistContextCharacter());	// zamienia symbole z listy wejściowej na listę słów kodowych
//	     
//	     CodeWriter cw_TC = new CodeWriter();																	// nowy obiekt zapisywacza do pliku
//	     
//	     cw_TC.saveCodeToFile(codesList_CC, dictionary_CC);														// zapisuje słowa kodowe do pliku
//	     
//	     
//	     // KONIEC TESTU CAŁOŚCIOWEGO DLA CONTEXT CHARACTER ##########################################
	     
	     // TEST WCZYTYWANIA OBRAZÓW
	     
//	     BufferedImage bufferedImage = ImageIO.read(new File("/home/koda/lenaOriginal.png"));
//	     
//	     list<byte> imageBytList;
//	     
//	     byte[] pixels = ((DataBufferByte) bufferedImage.getRaster().getDataBuffer()).getData();
	     
	     // KONIEC TESTU WCZYTYWANIA OBRAZÓW
	     
	     
	     // TEST DLA TWO CHARACTERS #####################################################
	     
//	     ArrayList<TwoCharacters> test_alphabet_tc = new ArrayList<>();
//	     test_alphabet_tc.add(new TwoCharacters('d','u', 12));
//	     test_alphabet_tc.add(new TwoCharacters('p','a', 3));
//	     test_alphabet_tc.add(new TwoCharacters('b','i', 8));
//	     test_alphabet_tc.add(new TwoCharacters('s','k', 11));
//	     test_alphabet_tc.add(new TwoCharacters('u','p', 6));
//	     test_alphabet_tc.add(new TwoCharacters('a','$', 4));
//	     
//	     HuffmanTree<TwoCharacters> huff_tree_tc = new HuffmanTree<>(test_alphabet_tc);
//	     HashMap<TwoCharacters, BinaryBox> codes_tc = huff_tree_tc.getCodeDictionary();
//	     
//	     ArrayList<String> test_input_tc = new ArrayList<>();
//	     test_input_tc.add("du");
//	     test_input_tc.add("pa");
//	     test_input_tc.add("bi");
//	     test_input_tc.add("sk");
//	     test_input_tc.add("up");
//	     test_input_tc.add("a$");
//	     
//	     Translator test_translator = new Translator();
//	     ArrayList codesList_tc = test_translator.translateTC(codes_tc, test_input_tc);
//	     
//	     CodeWriter cw = new CodeWriter();
//	     
//	     cw.saveCodeToFile(codesList_tc, codes_tc);
	     
//	     KONIEC TESTU DLA TWO CHARACTERS #################################################
//	     
//	    // TEST DLA CONTEXTCHARACTER #######################################################
//	     
//	     ArrayList<ContextCharacter> test_alphabet_cc = new ArrayList<>();
//	     
//	     test_alphabet_cc.add(new ContextCharacter('d','^', 12));
//	     test_alphabet_cc.add(new ContextCharacter('o','d', 3));
//	     test_alphabet_cc.add(new ContextCharacter('o','o', 8));
//	     test_alphabet_cc.add(new ContextCharacter('p','o', 11));
//	     test_alphabet_cc.add(new ContextCharacter('a','p', 6));
//	     test_alphabet_cc.add(new ContextCharacter('l','a', 22));
//	     test_alphabet_cc.add(new ContextCharacter('b','l', 1));
//	     test_alphabet_cc.add(new ContextCharacter('i','b', 9));
//	     test_alphabet_cc.add(new ContextCharacter('s','i', 7));
//	     test_alphabet_cc.add(new ContextCharacter('k','s', 13)); // to ten 10ty element - od niego już się wywala
//	     //test_alphabet_cc.add(new ContextCharacter('a','k', 3));
//	     
//	     HuffmanTree<ContextCharacter> huff_tree_cc = new HuffmanTree<>(test_alphabet_cc);
//	     HashMap<ContextCharacter, BinaryBox> codes_cc = huff_tree_cc.getCodeDictionary();
//	     
//	     ArrayList<String> test_input_cc = new ArrayList<>();
//	     test_input_cc.add("^d");
//	     test_input_cc.add("do");
//	     test_input_cc.add("oo");
//	     test_input_cc.add("op");
//	     test_input_cc.add("pa");
//	     test_input_cc.add("al");
//	     
//	     Translator test_translator = new Translator();
//	     ArrayList codesList_cc = test_translator.translateCC(codes_cc, test_input_cc);
//	     
//	     CodeWriter cw = new CodeWriter();
//	     
//	     cw.saveCodeToFile(codesList_cc, codes_cc);
	     
//	     //KONIEC TESTU DLA CONTEXTCHARACTER #############################################
	}

}

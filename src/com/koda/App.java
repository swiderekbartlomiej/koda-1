package com.koda;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;


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
	    
//	 // TEST DLA SINGLE CHARACTER #####################################################################
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
//	     ArrayList<SingleCharacter> test_input = new ArrayList<>();
//	     test_input.add(new SingleCharacter('a'));
//	     test_input.add(new SingleCharacter('a'));
//	     test_input.add(new SingleCharacter('b'));
//	     test_input.add(new SingleCharacter('c'));
//	     test_input.add(new SingleCharacter('d'));
//	     test_input.add(new SingleCharacter('l'));
//	     test_input.add(new SingleCharacter('g'));
//	     test_input.add(new SingleCharacter('z'));
//	     test_input.add(new SingleCharacter('y'));
//	     test_input.add(new SingleCharacter('x'));
//	     test_input.add(new SingleCharacter('o'));
//	     test_input.add(new SingleCharacter('p'));
//	     test_input.add(new SingleCharacter('s'));
//	     
//	     Translator test_translator = new Translator();
//	     ArrayList codesList = test_translator.translateSC(codes, test_input);
//	     //codesList = test_translator.translateSC_New(codes, test_input);
//	     
//	     CodeWriter cw = new CodeWriter();
//	     
//	     cw.saveCodeToFile(codesList, codes,"text");
//	     
//		 // KONIEC TESTU DLA DLA SINGLE CHARACTER #####################################################
	     
	     
//	     // TEST DLA TWO CHARACTERS ###################################################################
//	     
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
//	     //DictionaryPrinter.printTCDictionary(codes_tc);
//	     
//	     ArrayList<TwoCharacters> test_input_tc = new ArrayList<>();
//	     test_input_tc.add(new TwoCharacters('d','u'));
//	     test_input_tc.add(new TwoCharacters('p','a'));
//	     test_input_tc.add(new TwoCharacters('b','i'));
//	     test_input_tc.add(new TwoCharacters('s','k'));
//	     test_input_tc.add(new TwoCharacters('u','p'));
//	     test_input_tc.add(new TwoCharacters('a','$'));
//	     
//	     Translator test_translator = new Translator();
//	     ArrayList codesList_tc = test_translator.translateTC_New(codes_tc, test_input_tc);
//	     
//	     CodeWriter cw = new CodeWriter();
//	     
//	     cw.saveCodeToFile(codesList_tc, codes_tc,"text");
//	     
//	    // KONIEC TESTU DLA TWO CHARACTERS ############################################################
     
//	    // TEST DLA CONTEXTCHARACTER ##################################################################
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
//	     //DictionaryPrinter.printCCDictionary(codes_cc);
//	     
//	     ArrayList<ContextCharacter> test_input_cc = new ArrayList<>();
//	     test_input_cc.add(new ContextCharacter('d','^'));
//	     test_input_cc.add(new ContextCharacter('o','d'));
//	     test_input_cc.add(new ContextCharacter('o','o'));
//	     test_input_cc.add(new ContextCharacter('p','o'));
//	     test_input_cc.add(new ContextCharacter('a','p'));
//	     test_input_cc.add(new ContextCharacter('l','a'));
//	     
//	     Translator test_translator = new Translator();
//	     ArrayList codesList_cc = test_translator.translateCC(codes_cc, test_input_cc);
//	     
//	     CodeWriter cw = new CodeWriter();
//	     
//	     cw.saveCodeToFile(codesList_cc, codes_cc,"text");
//	     
//	     //KONIEC TESTU DLA CONTEXTCHARACTER ##########################################################
	     
//	     // TEST CAŁOŚCIOWY DLA SINGLE CHARACTER ######################################################
//	     
//	     InputReader ourReader = new InputReader("/home/koda/gen.txt"); 										//czyta plik wejsciowy
//	     ArrayList<SingleCharacter> alphabet_SC = ourReader.readToSingleCharacter(); 							// ładuje plik do struktury SingleCharacter
//	     
//	     alphabet_SC = ourReader.returnStatisticHashMapSC();
//	     
//	     HuffmanTree<SingleCharacter> huff_tree_SC = new HuffmanTree<>(alphabet_SC);							//buduje drzewo
//	     HashMap<SingleCharacter, BinaryBox> dictionary_SC = huff_tree_SC.getCodeDictionary();					//wyjmuje słownik z drzewa
//	     
//	     Translator translator_SC = new Translator();															// nowy obiekt translatora
//	     ArrayList codesList_SC = translator_SC.translateSC_New(dictionary_SC, ourReader.getListSingleCharacter());	// zamienia symbole z listy wejściowej na listę słów kodowych
//	     
//	     CodeWriter cw_SC = new CodeWriter();																	// nowy obiekt zapisywacza do pliku
//	     
//	     cw_SC.saveCodeToFile(codesList_SC, dictionary_SC,"text");														// zapisuje słowa kodowe do pliku
//	     
//	     
//	     // KONIEC TESTU CAŁOŚCIOWEGO DLA SINGLE CHARACTER ############################################
	     
//	     // TEST CAŁOŚCIOWY DLA TWO CHARACTERS ########################################################
//	     
//	     InputReader ourReader = new InputReader("/home/koda/lenaOriginal.png"); 										//czyta plik wejsciowy
//	     ArrayList<TwoCharacters> alphabet_TC = ourReader.readToTwoCharacters();								// ładuje plik do struktury SingleCharacter
//	     //ourReader.printStatisticHashMap();
//	     
//	     alphabet_TC = ourReader.returnStatisticHashMapTC();
//	     
//	     HuffmanTree<TwoCharacters> huff_tree_TC = new HuffmanTree<>(alphabet_TC);								//buduje drzewo
//	     HashMap<TwoCharacters, BinaryBox> dictionary_TC = huff_tree_TC.getCodeDictionary();					//wyjmuje słownik z drzewa
//	     
//	     //DictionaryPrinter.printTCDictionary(dictionary_TC);	
//	     
//	     Translator translator_TC = new Translator();															// nowy obiekt translatora
//	     
//	     ArrayList codesList_TC = translator_TC.translateTC_New(dictionary_TC, ourReader.getlistTwoCharacters());	// zamienia symbole z listy wejściowej na listę słów kodowych
//	     
//	     CodeWriter cw_TC = new CodeWriter();																	// nowy obiekt zapisywacza do pliku
//	     
//	     cw_TC.saveCodeToFile(codesList_TC, dictionary_TC,"image");														// zapisuje słowa kodowe do pliku
//	     
//	     
//	     // KONIEC TESTU CAŁOŚCIOWEGO DLA TWO CHARACTERS ##############################################
	     
//	     // TEST CAŁOŚCIOWY DLA CONTEXT CHARACTER #####################################################
//	     
//	     InputReader ourReader = new InputReader("/home/koda/lenaOriginal.png"); 										//czyta plik wejsciowy
//	     ArrayList<ContextCharacter> alphabet_CC = ourReader.readToContextCharacter();							// ładuje plik do struktury SingleCharacter
//	     //ourReader.printStatisticHashMap();
//	     
//	     
//	     alphabet_CC = ourReader.returnStatisticHashMapCC();	   
//	     
//	     HuffmanTree<ContextCharacter> huff_tree_CC = new HuffmanTree<>(alphabet_CC);							//buduje drzewo
//	     HashMap<ContextCharacter, BinaryBox> dictionary_CC = huff_tree_CC.getCodeDictionary();					//wyjmuje słownik z drzewa
//	     	     
//	     //DictionaryPrinter.printCCDictionary(dictionary_CC);
//	     
//	     Translator translator_CC = new Translator();															// nowy obiekt translatora
//	     ArrayList codesList_CC = translator_CC.translateCC_New(dictionary_CC, ourReader.getlistContextCharacter());// zamienia symbole z listy wejściowej na listę słów kodowych
//	     
//	     CodeWriter cw_TC = new CodeWriter();																	// nowy obiekt zapisywacza do pliku
//	     
//	     cw_TC.saveCodeToFile(codesList_CC, dictionary_CC,"image");														// zapisuje słowa kodowe do pliku
//	     
//	     
//	     // KONIEC TESTU CAŁOŚCIOWEGO DLA CONTEXT CHARACTER ###########################################
	     

	}

}

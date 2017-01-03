package com.koda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//import org.opencv.core.Core;
//import org.opencv.core.CvType;
//import org.opencv.core.Mat;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 //System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
	     //Mat mat = Mat.eye( 3, 3, CvType.CV_8UC1 );
	     //System.out.println( "mat = " + mat.dump() );
	     
	     System.out.println("KOOOOOOOODAAAAA");
	     
	     //InputReader ourReader = new InputReader("/home/koda/gen.txt");
	     // Poniżej wydruki ze wszystkich trzech metod, jako przykład.
	     //ourReader.printListSingleCharacter(ourReader.readToSingleCharacter());
	     //ourReader.printListTwoCharacters(ourReader.readToTwoCharacters());
	     //ourReader.printListContextCharacter(ourReader.readToContextCharacter());
	










     
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
	     
<<<<<<< HEAD
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
=======
	     ArrayList<SingleCharacter> test_alphabet = new ArrayList<>();
	     test_alphabet.add(new SingleCharacter('a', 10));
	     test_alphabet.add(new SingleCharacter('b', 14));
	     test_alphabet.add(new SingleCharacter('c', 5));
	     test_alphabet.add(new SingleCharacter('d', 20));
	     test_alphabet.add(new SingleCharacter('l', 24));
	     test_alphabet.add(new SingleCharacter('g', 7));
	     test_alphabet.add(new SingleCharacter('z', 15));
	     test_alphabet.add(new SingleCharacter('y', 16));
	     test_alphabet.add(new SingleCharacter('x', 23));
	     test_alphabet.add(new SingleCharacter('o', 12));
	     test_alphabet.add(new SingleCharacter('p', 19));
	     test_alphabet.add(new SingleCharacter('s', 9));
	     
	     HuffmanTree<SingleCharacter> huff_tree = new HuffmanTree<>(test_alphabet);
	     HashMap<SingleCharacter, BinaryBox> codes = huff_tree.getCodeDictionary();
	     
	     
	     ArrayList<String> test_input = new ArrayList<>();
	     test_input.add("d");
	     test_input.add("o");
	     test_input.add("o");
	     test_input.add("p");
	     test_input.add("a");
	     
	     Translator test_translator = new Translator();
	     ArrayList codesList = test_translator.translateSC(codes, test_input);
	     
	     CodeWriter cw = new CodeWriter();
	     
	     cw.saveCodeToFile(codesList, codes);
	     
		 // KONIEC TESTU DLA DLA SINGLE CHARACTER #####################################################

	     
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
//	     test_translator.translateTC(codes_tc, test_input_tc);
	     
//	     KONIEC TESTU DLA TWO CHARACTERS #################################################
	     
//	     TEST DLA CONTEXTCHARACTER #######################################################
	     
//	     ArrayList<ContextCharacter> test_alphabet_cc = new ArrayList<>();
//	     test_alphabet_cc.add(new ContextCharacter('d','^', 12));
//	     test_alphabet_cc.add(new ContextCharacter('o','d', 3));
//	     test_alphabet_cc.add(new ContextCharacter('o','o', 8));
//	     test_alphabet_cc.add(new ContextCharacter('p','o', 11));
//	     test_alphabet_cc.add(new ContextCharacter('a','p', 6));
//	     test_alphabet_cc.add(new ContextCharacter('l','a', 4));
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
//	     test_translator.translateCC(codes_cc, test_input_cc);
	     
//	     KONIEC TESTU DLA CONTEXTCHARACTER #############################################
>>>>>>> e4ed22070871c81fe64adca66f1dda306100c97a
	}

}

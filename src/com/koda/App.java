package com.koda;

import java.util.ArrayList;

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
	}

}

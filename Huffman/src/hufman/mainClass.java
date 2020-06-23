package hufman;

import java.util.ArrayList;
import java.util.List;

public class mainClass {

	public static void main(String[] args) {
	
		
		 Huffman h = new Huffman();
		 
		 List<huffmanObject> A = new ArrayList();
		 List<huffmanObject> G = new ArrayList();
		 
		 A.add( new huffmanObject( "H" , 1) ) ;
		 A.add( new huffmanObject( "u" , 1) ) ;
		 A.add( new huffmanObject( "m" , 1) ) ;
		 A.add( new huffmanObject( "a" , 1) ) ;
		 A.add( new huffmanObject( "n" , 1) ) ;
		 A.add( new huffmanObject( "f" , 2) ) ;
			
		 h.huffman(A, G);

		 

			System.out.println(  "\n" + "Displayyn data of array " + "\n" );
		for( int i = 0 ; i < G.size() ; i++ ) {
			System.out.println( G.get( i ) );
			
		}

		
	}

}

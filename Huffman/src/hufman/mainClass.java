package hufman;

import java.util.ArrayList;
import java.util.List;

public class mainClass {

	public static void SelectionSort( LinkedList<HuffmanNode> a ) {
		int pos ;
		// int min ;
		int n = a.size() ;
		for( int j = 0 ; j < n - 1 ; j++ ) {
			pos = j ;
			for( int i = j + 1 ; i < n ; i++ ) { if( a.get( i ).vlNr < a.get( pos ).vlNr ) { pos = i; } }
			HuffmanNode temp = a.get( j ) ;
			a.set( j , a.get( pos ) )  ;
			a.set( pos , temp ) ;
		}
	}
	
	public static void HmTreeTravel( HuffmanNode hn, String s ) {
		if( hn.left == null && hn.right == null ) { System.out.println( hn.c + " -->   " + s ); }
		if( hn.left != null  ) { HmTreeTravel( hn.left, s + "1" ); }
		if(  hn.right != null ) { HmTreeTravel( hn.right, s + "0" ); }	
	}
	
	public static void main(String[] args) {
		char[] characters ={ 'H', 'u', 'f', 'm', 'a', 'n'  };
		int[] freq = { 1, 1, 2, 1, 1, 1 };
		int n1 = freq.length ;
		LinkedList <HuffmanNode> que = new LinkedList <HuffmanNode>();
		for( int i = 0 ; i < n1 ; i ++){	
			HuffmanNode hn = new HuffmanNode();
			hn.vlNr = freq[ i ];
			hn.c = characters[ i ];
			hn.left = null ;
			hn.right = null ;
			que.add( hn) ;
		}
		SelectionSort( que);
		HuffmanNode root = null;
		while( que.size() > 1){
			SelectionSort( que);	
			HuffmanNode X = que.poll();
			HuffmanNode y = que.poll();
			HuffmanNode n = new HuffmanNode();
			n.vlNr = X.vlNr + y.vlNr ;
			n.c = '-';
			n.left = X;
			n.right = y;
			root = n ;
			que.add( n) ;
		}
		HmTreeTravel( root, "" );	
	}
}

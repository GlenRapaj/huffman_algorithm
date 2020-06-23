package hufman;

import java.util.List;

public class Huffman {
	
	

	
	public static void switchElment( List<huffmanObject> arr , int firstPosition , int secondPositin ) {
		
		huffmanObject temp = arr.get(firstPosition);
		arr.set( firstPosition, arr.get(secondPositin) )   ;
		arr.set(secondPositin, temp)   ;
		
	}
	
	
	
	
	public static int getRightChildPosition(  int position ) {  //  List<huffmanObject> arr nuk duhet  // List<huffmanObject> arr ,
		
		int i =  ( position * 2 ) + 2 ;
		
		return i ;
	}
	
	
	public static int getLeftChildPosition(  int position ) {  // List<huffmanObject> arr nuk duhet  // List<huffmanObject> arr ,
		
		int i =  ( position * 2 ) + 1 ;
		
		return i ;
	}
	
	
	
	public static void createMinHeapNew( List<huffmanObject> arr , int size  ) {
		
		for( int i = 0 ; i < size/2 ; i++ ) {
			
			int rcp = getRightChildPosition(  i );  // arr ,
			int lcp = getLeftChildPosition(   i );  // arr ,
			
			if( rcp < size &&  arr.get(rcp).getNodeWeght() < arr.get( i ).getNodeWeght()  ) {
				switchElment( arr , rcp , i );
			}
			
			
			if( lcp < size &&  arr.get(lcp).getNodeWeght() < arr.get( i ).getNodeWeght()  ) {
				switchElment( arr , lcp , i );
			}
			
		}
	}
	
	public static void createMaxHeapNew( List<huffmanObject> arr , int size  ) {
		
		for( int i = 0 ; i < size/2 ; i++ ) {
			
			int rcp = getRightChildPosition(  i );  // arr ,
			int lcp = getLeftChildPosition(   i );  // arr ,
			
			if( rcp < size &&  arr.get(rcp).getNodeWeght() > arr.get( i ).getNodeWeght()  ) {
				switchElment( arr , rcp , i );
			}
			
			
			if( lcp < size &&  arr.get(lcp).getNodeWeght() > arr.get( i ).getNodeWeght()  ) {
				switchElment( arr , lcp , i );
			}
			
		}
	}
	
	
	

	
	public static void maxHeapify( List<huffmanObject> arr , int size , int index ){
		// for Max heap 
		int l = index ;
		int leftNode = 2* index + 1 ;
		int rightNode = 2* index + 2 ;
		
		if( leftNode < size && arr.get( l ).getNodeWeght() < arr.get(leftNode).getNodeWeght() ) {
			l = leftNode ;
		}
		
		if( rightNode < size && arr.get( l ).getNodeWeght() < arr.get(rightNode).getNodeWeght() ) {
			l = rightNode ;
		}
		
		if( l != index ) {
			/*
			int temp = arr[ index ] ;
			arr[ index ] = arr[ l ] ;
			arr[ l ] = temp ;
			*/
			
			switchElment( arr , l , index );
			
			maxHeapify( arr , size , l ) ;
		}
	}
	
	public static void minHeapify( List<huffmanObject> arr , int size , int index ){
		// for Min heap 
		int l = index ;
		int leftNode = 2* index + 1 ;
		int rightNode = 2* index + 2 ;
		
		if( leftNode < size && arr.get(l).getNodeWeght() > arr.get(leftNode).getNodeWeght() ) {
			l = leftNode ;
		}
		
		if( rightNode < size && arr.get(l).getNodeWeght() > arr.get(rightNode).getNodeWeght() ) {
			l = rightNode ;
		}
		
		if( l != index ) {
			
			switchElment( arr , l , index );
			minHeapify( arr , size , l ) ;
		}
	}
	
	
	public static void maxHeapSort( List<huffmanObject> arr , int size ){
		
		 createMaxHeapNew( arr , size  );
		 
		while ( size > 1 ) {
			maxHeapify(  arr ,  size , 0 );
			 switchElment( arr , 0 ,  size - 1  );
			size-- ;
		}
	}
	
	
	public static void minHeapSort( List<huffmanObject> arr , int size ){
		
		createMinHeapNew( arr , size  );
		 
		while ( size > 1 ) {
			minHeapify(  arr ,  size , 0 );


			  switchElment( arr , 0 ,  size - 1 );
			size-- ;
		}
	}
	
	
	
	public void huffman( List<huffmanObject> A , List<huffmanObject> G ) {
		
		createMaxHeapNew( A , A.size()  );
		
		
		while( A.size() > 1 ) {
		
			huffmanObject ho2  = A.get( 1 );
			huffmanObject ho1  = A.get( 0 );
			
			huffmanObject ho = new huffmanObject( "MidleNode", ho2.getNodeWeght() + ho1.getNodeWeght() );
			
			A.remove( 1 ) ;
			A.remove( 0 ) ;
			
			G.add( ho2 );
			G.add( ho1 );
			
			A.add( ho );
			
			maxHeapSort( A , A.size() );
			
	}
		
		G.add( A.get( 0 ) );
		minHeapSort( G , G.size() ) ;
		
	}
	
	

}

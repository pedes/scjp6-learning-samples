package net.mgorski.scjp.tests.collections.copy;

import java.util.TreeMap;

public class Collections {
	
	public static void main(String[] args) {
		
		//TreeMap<int, String > tm0; // WRONG !!
		
		TreeMap<int[], String > tm1; 
		TreeMap<int[], String > tm2 = new TreeMap<int[], String>();
		
		//TreeMap<int[], String > tm3 = new TreeMap<int[20], String>(); // WRONG !! [ 20 ]
			
		
		TreeMap<Short, String > tm4 = new TreeMap<Short, String>();
		
		
		tm4.put((short) 4, "quatro");
	}
	
	
	public void treeMap() {
		
		
		/**
		 * 
		 * Serializable
		 *		
		 * Map
		 * 
		 * AbstractMap implements  NavigableMap<K,V>, Cloneable, java.io.Serializable
		 * 							extends Sorted Map 
		 * 
		 * TreeMap
		 * 
		 * 
		 * 							 
		 */
		
	}

}

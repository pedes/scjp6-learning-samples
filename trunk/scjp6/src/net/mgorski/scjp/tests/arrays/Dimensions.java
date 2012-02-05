package net.mgorski.scjp.tests.arrays;

public class Dimensions {
	
	public static void main(String[] args) {
		int[] a = null ,  b[] = null;
//		b = a; // CONVERSION [][] ---> [] !!!
		System.out.println( b );
		
		int[] k,l,m,n = null;
		
		int [][]kk, kkkk[][];
		
//		kkkk = new int[][][][]; // WRONG !!!
		
		
		kkkk = new int[666][][][]; // OK (only first one)
		
		
	}

}

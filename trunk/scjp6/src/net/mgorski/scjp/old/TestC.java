package net.mgorski.scjp.old;


public class TestC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		 int arr[][] = new int[5][5];

		 int[]arr2[] = new int[5][5];

		 int []arrr3[] = new int[5][];

         int[][][][] arrrr4 = new int[2][][][];
         
         System.gc();
         
         Runtime rt = Runtime.getRuntime();
         rt.gc();

	}

}

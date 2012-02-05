package net.mgorski.scjp.old;

public class Arithmetic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		System.out.println( " 1> " + 10 % 3 );
		System.out.println( " 2> " + 3 % 10 );
		System.out.println( " 3> " + 10 % -3 );
		
		System.out.println( " 4> " + (true | false) );
		System.out.println( " 5> " + (true || false) );
		
		
		/**
		 * false ^ true ----> TRUE
		 * true ^ false ----> false
		 */
		System.out.println( " 6> " + (true ^ false) );
		System.out.println( " 7> " + (false ^ true) );
		
		/**
		 * false ^ false ---> false
		 * true ^ true ---> false
		 */
		System.out.println( " 8> " + (true ^ true) );
		System.out.println( " 9> " + (false ^ false) );
		
		/**
		 * false & true ----> false
		 * true & false ----> false
		 */
		System.out.println( " 10> " + (true & false) );
		System.out.println( " 11> " + (false & true) );
		
		
		final Integer n = 0;
		
//		n++;  // bad !
		
		
		int []arr = new int[]{1,2,3,4};
		for ( int i : arr )
		{
			System.out.println("III" + i);
		   arr[i] = 0;
		}
		for ( int i : arr )
		{
		   System.out.println(i);
		}

	}

}

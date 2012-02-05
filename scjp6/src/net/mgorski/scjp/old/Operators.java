package net.mgorski.scjp.old;

public class Operators {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		String dupa = null;
		
		if ( dupa != null && dupa.equals(new String("aaa")) || dupa.contains("b") ){
			System.out.println("Null pointer here!");
		}
		
		
	}

}

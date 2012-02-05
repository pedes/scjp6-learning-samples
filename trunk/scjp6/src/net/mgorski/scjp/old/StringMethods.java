package net.mgorski.scjp.old;

public class StringMethods {
	
	
	public static void main(String[] args) {
		
		
		
		
		StringBuffer stringBufferThreadSafe = new StringBuffer("abcd");
		
		StringBuilder stringBuilder = new StringBuilder("abcd");
		
		String string = new String();
		
		
		printStrings(0, "aaaa");
		printStrings(0, new String[] { "bbbb", "cccc"} );
		
		String[] str = new String[] { "ddd", "eee", "fff" };
		printStrings(0, str);

		
		printStrings(7);
	}
	
	
	private static void printStrings(int i, String ...  strings /*, int k NOT ALLOWED */){
		
		int j = 0;
		System.out.println("Entry : " + i + ", " + strings.length); // declared but empty if no param !
		for (String one : strings) {
			
			System.out.println("Strings ["+j+"]  " + one);
			
		}
		
	}
}

package net.mgorski.scjp.old;

import java.io.Externalizable;
import java.text.DateFormat;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.List;

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
		
		System.out.println("----");
		StringBuilder sb = new StringBuilder();
		String s = null;
		sb.append(s);
		sb.append("123");
//		sb.append(0,"1");
		System.out.println(sb.toString());

		List<String> l = new LinkedList<String>();
		l.add("aaa");
		l.add("bbb");
		String[] array = l.toArray(new String[0]);
		System.out.println(array.length);
	}
	
	
	private static void printStrings(int i, String ...  strings /*, int k NOT ALLOWED */){
		
		int j = 0;
		System.out.println("Entry : " + i + ", " + strings.length); // declared but empty if no param !
		for (String one : strings) {
			
			System.out.println("Strings ["+j+"]  " + one);
			
		}
		
	}
}

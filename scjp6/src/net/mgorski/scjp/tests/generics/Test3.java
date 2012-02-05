package net.mgorski.scjp.tests.generics;

import java.util.ArrayList;

public class Test3 {
	public static void main( String args[] )
	{
	   List<? extends Number> type = new ArrayList<Integer>(); // 1
	   for ( Integer n : type )    // 2
	   {
	      System.out.println(n); // 3
	   }
	}
	public <T> void seth(List<?> type)   // 4
	{
	   type.add("hi");   // 5
	}
}

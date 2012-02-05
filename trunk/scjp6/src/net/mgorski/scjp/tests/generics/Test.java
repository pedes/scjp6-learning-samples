package net.mgorski.scjp.tests.generics;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

class Test <T>
{
   public static void main( String args[] )
   {
      new Test<String>().meth("hello"); // 1
      
      new Test<Integer>().meth(new Integer(1)); // 1
      
      new Test<int[]>().meth(new int[] { 1,2,3} ); // 1
      
      new Test<Set<? extends Serializable>>().meth(new HashSet<Date>()); // 1
      
   }

   public void meth(T type) // 2
   {
      System.out.println(" type " + type); // 3
   }
   
}
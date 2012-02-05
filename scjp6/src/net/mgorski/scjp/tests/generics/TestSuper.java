package net.mgorski.scjp.tests.generics;

import java.util.ArrayList;
import java.util.List;

class TestSuper 
{
   static List<? super String> tester = new ArrayList < String >();
   
   
   static Byte $myvariable;
   static Byte _myvariable;
//   static Byte #myvariable;
//   static Byte !myvariable;
//   static Byte 0myvariable;
//   static Byte -myvariable;
//   static Byte @myvariable;
//   static Byte$ %myvariable;
   
   
   public static void main( String args[] )
   {
      seth( tester ); // 2
   }

   public static <T> void seth(List<? super String> type)
   {
      type.add("hi"); // 1
   }
   
   
}
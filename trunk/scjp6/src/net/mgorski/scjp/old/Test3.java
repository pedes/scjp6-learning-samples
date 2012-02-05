package net.mgorski.scjp.old;

import java.util.Date;

public class Test3 {
	 public static void main(String args[]) {

         Date d1 = new Date (99, 11, 31);

         Date d2 = new Date (99, 11, 31);

         method(d1, d2);
         
//         d2.setYear(103);

         System.out.println("d1 is " + d1 

                    + "\nd2 is " + d2);
         //d1 is Fri Dec 31 00:00:00 CET 1999
         //d2 is Sun Dec 31 00:00:00 CET 2000

   }

   public static void method(Date d1, Date d2) {

         d2.setYear (100);

         d1 = d2;
         d1.setYear(101);
         
         System.out.println("YEAR " + d1 + " , " + d2);
         

   }
}

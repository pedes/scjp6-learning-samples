package net.mgorski.scjp.old;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Operators {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception{

        short s1 = 2;
        int s2 = 2;

        if (s1 == s2) {
            System.out.println("equals short");
        }

        boolean b1 = false;
        boolean b2 = true;
        if (b1 ^ b2) {
            System.out.println("equals xor");
        }

        String dupa = null;

        try {
            if (dupa != null && dupa.equals(new String("aaa")) || dupa.contains("b")) {

            }
        } catch (NullPointerException npe) {
            System.out.println("Null pointer here!");
        }

        int x = 1;
        final int y = 1;
        final Integer in = new Integer("1");
        switch (x) {
        
        case y: {
            System.out.println("is 1");
            //break;
        } 
        case Integer.MAX_VALUE : {
            // max
            break;
            
        }
        default : {
            System.out.println("default");
        }
            ;
        }
        
        long[] longs = new long[]{1,2L};
        for (Long l : longs){
            System.out.println(l);
        }
        
        
        try{
            int n = 5%0;
            System.out.println(n);
        } catch(Throwable t){
         System.out.println("throwable");   
        }finally {
        }
            
        throw new OutOfMemoryError();
        
        try {
         // do risky IO things
         } catch (IOException e) {
         // handle general IOExceptions
         } catch (FileNotFoundException ex) {
         // handle just FileNotFoundException
         }
        
    }

}

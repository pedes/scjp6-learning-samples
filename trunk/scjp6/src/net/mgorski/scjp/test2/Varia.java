package net.mgorski.scjp.test2;

import java.io.File;
import java.util.Hashtable;

public class Varia {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder("n");
        File f = new File(".");
        String st = "";
        
//        Object o = f+sb; // illegal
        Object o2 = sb+ st+f;
        
        System.out.println(o2.getClass());
        System.out.println(o2);
        
        Hashtable<String, Integer> s = new Hashtable<String, Integer>();

        int i = 12323;
        int[] ints[] = new int[][] { { 2, 2 } };
        int[][][] triple = new int[][][] { { { 3 } } };
        int[][][] triple2 = new int[][][] { { { 3 } }, { new int[2] }, { new int[] { 2, 2, 2 } } };

        float fc = '2';
        float fd = (float) -12.2232323;
        float fi = 1;
        float ff = 1f;

        System.out.printf(" %1$+2.#", fd);
        
        

        
        
        
        
        
        

        try {

        } catch (IllegalStateException e) {
            // runtime exception allowed with catch block

        } finally {
            throw new RuntimeException(""); // also ok
            //
        }
        
        
        
        

    }
}

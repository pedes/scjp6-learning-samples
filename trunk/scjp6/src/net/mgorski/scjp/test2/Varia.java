package net.mgorski.scjp.test2;

import java.io.IOException;
import java.util.Hashtable;
import java.util.UnknownFormatConversionException;

public class Varia {

    public static void main(String[] args) {
        Hashtable<String, Integer> s = new Hashtable<String, Integer>();

        int i = 12323;
        int[] ints[] = new int[][] { { 2, 2 } };
        int[][][] triple = new int[][][] { { { 3 } } };
        int[][][] triple2 = new int[][][] { { { 3 } }, { new int[2] }, { new int[] { 2, 2, 2 } } };

        float fc = '2';
        float fd = (float) -12.2232323;
        float fi = 1;
        float ff = 1f;

        System.out.printf(" %1$+2.#f", fd);

        try {

        } catch (IllegalStateException e) {
            // runtime exception allowed with catch block

        } finally {
            throw new RuntimeException(""); // also ok
            //
        }

    }
}

package net.mgorski.scjp.test2;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.Hashtable;

public class Varia {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder("n");
        File f = new File(".");
        String st = "";

        // Object o = f+sb; // illegal
        Object o2 = sb + st + f;

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

        System.out.printf(" %1$+2.2f\rx\n", fd);

        // types

        short x = 1;
        short xx = 1024;
        
        Short bigX = new Short("32767");
        
//        test(1,1);// will not compile
        test(); // this will work !
        test(x);
        test(x,x);
        test(bigX);
        test(bigX, x);
//        test(null, bigX, bigX); // not
        test ((short) 1, (short) 44, bigX.shortValue(), bigX, x);
        test("");
        test(new Serializable(){});
        
        long buffer=1024;
        int in = Integer.valueOf(1);
        new Long(buffer);
        
        
        double myD = 23;
        int myI = -3;
        
        Object myO = myI / myD;
        System.out.printf("value of myO=%1$2.10f\n", Double.valueOf(myO.toString()));
        
        
        System.out.printf("b formatter null = %1$b\n", null);
        System.out.printf("b formatter false = %1$b\n", false);
        System.out.printf("b formatter wrapper/true = %1$b\n", Boolean.TRUE);
        System.out.printf("b formatter something else = %1$b\n", new Object());
        System.out.printf("b formatter string true = %1$b\n", "true");
        System.out.printf("b formatter string tRUe = %1$b\n", "tRUe");
        System.out.printf("b formatter string fALse = %1$b\n", "fALse");
        
        System.out.printf("h formatter 30 = %1$h\n ", 30);
        System.out.printf("month is = %1$tm\n", new Date());

        System.out.println("\n\n" + x + " -> " + xx + "," + Short.MAX_VALUE);
        
        
        Object [] object = new String[5][5];
        int counter=0;
        for (Object o : object )
        {
            System.out.println(o);
            counter++;
        }
        System.out.println("Counter:"+counter);

        try {

        } catch (IllegalStateException e) {
            // runtime exception allowed with catch block

        } finally {
            throw new RuntimeException(""); // also ok
            //
        }

    }

//    static void test(){
//        System.out.println("no args");
//    }
    
    static void test(Object ...o){
        System.out.println("Vararg object length" + o.length);
    }
    static void test(short... s) {
        System.out.println("Vararg short length" + s.length);
    }
}

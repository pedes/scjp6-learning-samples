package net.mgorski.scjp.book.s17arrays;

import junit.framework.TestCase;

public class ArraysTest extends TestCase {
    
    public void testArrays() {
        
        simplest();
            onLineInitialization();
        
    }

    /**
     * 
     */
    private void simplest() {
        int keys[];         // bad, but compiles
        int [] keys2;
        int [  ] keys3;     // bad, but compiles
        
        int[][][]dups[][];  // 5 dimensional, correct, bad again
        
        
        int [][] _2d = new int [2][];
        _2d[0]= new int[1];
        _2d[0][0] = 2;
        _2d[1]= new int[1];
        _2d[1][0] = 3;
        
        System.out.println(_2d);
        
        
        int [] x = new int[2];
        
        try {
            x[-1] = 2; // runtime exception
            fail();
        } catch (RuntimeException re){
            System.out.println(">> runtime exception " + re.getClass());
        }
        
        
        
        int[][] square = new int[2][2];
    }
    

    private void onLineInitialization() {
        
     
        int x[] = { 0, 1, 2, 3};
        assertEquals(4, x.length);
        
        int [][] scores= {{}, {1,2}, {33,33,33}};
        for (int i = 0; i < scores.length; i++) {
            System.out.println("lenght=" + scores[i].length);
        }
        
    }
}

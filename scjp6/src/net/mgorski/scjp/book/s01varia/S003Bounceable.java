package net.mgorski.scjp.book.s01varia;

import java.io.Serializable;

import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;

public interface S003Bounceable {

    public static int MAX = 100;
    //public static volatile int MAX2 = 100; // wrong! wrong!
    public static final int MAX3 = 100;

    public int x = 1;
    
    void bounce();

    // private void bouncePrivate(); // wrong
    // protected void bouncePrivateProt(); // wrong
    public void bouncePrivatePub();

    abstract void dupa();
//     static void eatCock(); // wrong and bad name
}

interface Two extends S003Bounceable, Serializable {

}

class TestInstance extends TestCase implements S003Bounceable{

    @Override
    public void bounce() {
        // MAX3 = 3; // WRONG
//         MAX = 1022; // WRONG, final implicitly!
    }

    @Override
    public void bouncePrivatePub() {
        // TODO Auto-generated method stub

    }

    @Override
    public void dupa() {
        // TODO Auto-generated method stub

    }
    
    @Test
    public static void testRun(){
        System.out.println("success");
        Assert.assertNull(null);
    }

}

package net.mgorski.scjp.book.s19operators;

import java.io.Serializable;

import junit.framework.TestCase;

import org.junit.Test;

public class OperatorTest extends TestCase {

    @Test
    public void testOne() {

        A a = new A();
        B b = new B();

        assertTrue(a instanceof B);
        assertTrue(a instanceof A);
        assertTrue(a instanceof Serializable);

        assertTrue(b instanceof B);
        assertFalse(b instanceof A);

        Zdupy zdupy = new Zdupy();

        // assertFalse(zdupy instanceof A); // not compiles!

        assertTrue(zdupy instanceof Object);

        int[] poo = new int[2];
        assertTrue(poo instanceof Object);

    }

    @Test
    public void testBitComparision() {

        int a = 0x1; // 1
        int b = 0x010; // 2
        int c = 0x101; // 4
        System.out.println("a=" + a + " b=" + b + " c=" + c);
        System.out.println("comparision=" + (a | b));

        int x = 0;
        x = x >>> 1;

        x >>>= 1;   // exists (shift w/o sign bit)
        //x <<<= 1; // does not exist

    }

    class A extends B {
        private static final long serialVersionUID = 1L;
    }

    class B implements Serializable {
        private static final long serialVersionUID = 1L;
    }

    class Zdupy {

    }
}

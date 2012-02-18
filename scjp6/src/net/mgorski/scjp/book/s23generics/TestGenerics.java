package net.mgorski.scjp.book.s23generics;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class TestGenerics {

    public static void main(String[] args) {

        // List<Number> numbers = new ArrayList<Integer>(); // wrong!
        List<Number> numbers = new ArrayList<Number>(); // ok
        numbers.isEmpty();

        Number[] numberArray = new BigInteger[1]; // ok !
        // numberArray[0] = 112; // autoboxing to integer, will not be added !
        numberArray[0] = new BigInteger(-1, new byte[] { 0x02, 0x01 }); // TODO
        System.out.println(numberArray[0]);

        List<? extends Number> nums = new LinkedList<Integer>();
        // nums.add(new Integer(1)); //wrong
        nums.add(null);// ok

        List<Integer> l2 = new Vector<Integer>(1);
        l2.add(1);

        nums = l2;

        System.out.println(nums.size());
        System.out.println(nums.get(0).getClass());

        GenericClass gc = new GenericClass(1);
    }

    
}

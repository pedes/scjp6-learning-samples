package net.mgorski.scjp.book.s23generics;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class TestGenerics {
    
    public static void main(String[] args) {
        
        
//        List<Number> numbers = new ArrayList<Integer>(); // wrong!
        List<Number> numbers = new ArrayList<Number>(); // ok
        numbers.isEmpty();
        
        Number[] numberArray = new BigInteger[1]; // ok !
//        numberArray[0] = 112;   // autoboxing to integer, will not be added !
        numberArray[0] = new BigInteger(-1, new byte[]{ 0x02, 0x01 }); // TODO
        System.out.println(numberArray[0]);
        
        
        
    }
}

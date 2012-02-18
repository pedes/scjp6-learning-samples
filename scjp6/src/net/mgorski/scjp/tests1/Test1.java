package net.mgorski.scjp.tests1;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import java.util.ArrayList;

public class Test1 {
    
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<Integer>();
//        List<Number> nums = ints; /// wrong!
        
        List<? extends Number> numbers = new LinkedList<Number>();
        List<? super Number> numbers2 = new LinkedList<Number>();
        
        int a[] = {1,2};
    } 

}

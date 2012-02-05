package net.mgorski.scjp.book.s10vectors;

import java.util.Collections;
import java.util.List;


public class ImmutableList {
    
    public static void main(String[] args) {
        
        
        List<String> myList = Collections.emptyList();
        for (String string : myList) {
            System.out.println("Local : " +string);
        }
        
        
        myList.add("dupa"); // runtime error in this line!
        
    }
}

package net.mgorski.scjp.book.s09collections;

import java.util.Collection;
import java.util.LinkedList;

public class TestUtils {
    
    public static void main(String[] args) {
        
        LinkedList<String> l1 = new LinkedList<String>();
        l1.add("A1");
        l1.add("A2");
        
        
        LinkedList<String> l2 = new LinkedList<String>();
        l2.add("B1");
        l2.add("B2");
        
        Collection<String> mergeCollections = Util.mergeCollections(l1, l2);
        
        System.out.println("MERGED-----");
        for (String string : mergeCollections) {
            System.out.println("element : " + string);
        }
        
        System.out.println("L1-----");
        for (String string : l1) {
            System.out.println("element : " + string);
        }
        
        System.out.println("L2-----");
        for (String string : l2) {
            System.out.println("element : " + string);
        }
        
    }

}

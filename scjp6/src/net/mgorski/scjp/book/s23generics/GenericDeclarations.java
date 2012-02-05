package net.mgorski.scjp.book.s23generics;

import java.util.Arrays;
import java.util.List;

public class GenericDeclarations {
    
    public static void main(String[] args) {

        Integer[] ints = {1,2,3,4};
        List<Integer> asList = Arrays.asList(ints);
        StrageContainer<String, Integer, String> strange = new StrageContainer<String, Integer, String>("first", asList, "second");
        
        System.out.println(strange.getFirst());
        System.out.println(strange.getSecond());
        System.out.println(strange.getListElement(2));
        
    }
}


class StrageContainer<H,U,J> { // only convention
    
    H h;
    List<U> us;
    J j;
    
    public StrageContainer(H h, List<U> u, J j){
        this.h = h;
        this.us = u;
        this.j = j;
    }
    
    H getFirst(){
        return h;
    }
    
    J getSecond(){
        return j;
    }
    
    U getListElement(int idx){
        return us.get(idx);
    }
}

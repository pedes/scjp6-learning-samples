package net.mgorski.scjp.book.s23generics;

import java.util.LinkedList;
import java.util.List;

public class Methods {
    
    public static void main(String[] args) {
        
    }
}

class GenericMethod<T, B> {
    
    List<T> list;
    
    
//    public void createList(W type) { // not correct, W is not valid !!!
//        list = new LinkedList<T>();
//    }
    
    public <W> void createListW(W type) {
        list = new LinkedList<T>();
    }
    
    
    public void createListB(B type) { // other way is to add parameter to the class
        list = new LinkedList<T>();
    }
    
    
}


//public class NumberHolder<? extends Number> { } // not correct

//public class NumberHolder<? super Number> { } // not correct either

package net.mgorski.scjp.book.s05inheritance;

public class Apple extends Fruit {

    public Apple() {
        // will not compile
//        super();
        System.out.println( "apples" );   
    }
    
}

package net.mgorski.scjp.book.s05inheritance;

public class Apple extends Fruit {

    public Apple() {
        super(new Object());// must be placed here
        
        System.out.println( "apples" );   
    }
    
}

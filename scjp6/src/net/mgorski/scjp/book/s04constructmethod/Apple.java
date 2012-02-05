package net.mgorski.scjp.book.s04constructmethod;

public class Apple extends Fruit {

    public Apple() {
        System.out.println("apple");   
    }
    
    public void Apple() {
        System.out.println("apple-method");
    }
    
    public Apple(int i){
        this();
        System.out.println("apple="+i);   
    }
    
}

package net.mgorski.scjp.book.s05inheritance;

public class RunME {

    public static void main(String[] args) {
        new Apple();
        
        Fruit[] fruits = new Apple[1];
        
        // illegal!
//        Apple[] apples = new Fruits[1];
    }
}

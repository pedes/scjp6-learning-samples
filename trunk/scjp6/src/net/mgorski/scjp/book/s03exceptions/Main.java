package net.mgorski.scjp.book.s03exceptions;

public class Main {
    
    public static void main(String[] args)  {
        
        Class c = new Class();
        Class s = new Subclass();
//        System.out.println( s.foo( 5 ) ); // not compiles (need catch)
//        System.out.println( c.foo( 10 ) ) ;// not compiles (need catch)
    }
}

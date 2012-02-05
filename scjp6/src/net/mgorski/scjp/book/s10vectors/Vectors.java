package net.mgorski.scjp.book.s10vectors;

import java.util.Vector;

public class Vectors {
    
    public static void main(String[] args) {
        
        
        
        Vector<String> v = new Vector<String>();
        
        
        System.out.println( v.size() + ", " + v.capacity() ); // 10
        
        v.add( "dupa ");
        
        System.out.println( v.size() + ", " + v.capacity() ); // 10
        
        v.add( "dupa ");
        v.add( "dupa ");
        v.add( "dupa ");
        v.add( "dupa ");
        v.add( "dupa ");
        v.add( "dupa ");
        v.add( "dupa ");
        
        System.out.println( v.size() + ", " + v.capacity() ); // 10
        
        v.add( "dupa ");
        
        System.out.println( v.size() + ", " + v.capacity() ); // 10
        
        v.add( "dupa ");
        
        System.out.println( v.size() + ", " + v.capacity() ); // 10
        
        
        v.add( "dupa ");
        v.add( "dupa ");
        v.add( "dupa ");
        v.add( "dupa ");
        v.add( "dupa ");
        v.add( "dupa ");
        v.add( "dupa ");
        
        System.out.println( v.size() + ", " + v.capacity() ); // 10
        
        v.ensureCapacity(10000000);
        
        for (int i = 0; i < 1000000; i++) {
            v.add("test");
        }
        
        System.out.println( v.size() + ", " + v.capacity() ); // 10
        
    }
}

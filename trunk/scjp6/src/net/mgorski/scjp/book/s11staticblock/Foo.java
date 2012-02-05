package net.mgorski.scjp.book.s11staticblock;

public class Foo {
    
    private final Bar bar1;
    private final Bar bar2 = new Bar(2);
    
    {
        bar1 = new Bar(1);
    }
    
    public Foo() {
        System.out.println("Contrsuctor #1");
    }
    
   
    private class Bar {
        
        public Bar( int i ) {
            System.out.println("Bar=" + i);
            
            {
                System.out.println("block");
            }
            
            
        }
    }
    
    static {
        System.out.println("static block");
    }
    
}

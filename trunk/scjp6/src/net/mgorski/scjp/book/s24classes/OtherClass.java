package net.mgorski.scjp.book.s24classes;

import net.mgorski.scjp.book.s24classes.OuterClass.TypicalInnerClass;


public class OtherClass {
    
    
    public static void main(String[] args) {
        OuterClass ic = new OuterClass();
//      OuterClass.TypicalInnerClass tic = new TypicalInnerClass(); // not correct !
        
        ic.stringDefault = "3"; // the lowest we can access
        
        TypicalInnerClass inner = ic.createTypicalInner();
        inner.getSth(); // also here default is the lowest
        
        
        OuterClass ic2 = new OuterClass();
        TypicalInnerClass typicalInnerClass = ic2.new TypicalInnerClass(); // oh, lol-syntax
        TypicalInnerClass typicalInnerClass2 = new OuterClass().new TypicalInnerClass(); // also ok
        
        ic2 = null; // nullify 
        System.out.println(typicalInnerClass.toString() + " of " + ic2); // ok
        
        
        
    
        OuterClass outer = new OuterClass();
        OuterClass.TypicalInnerClass typical = outer.createTypicalInner();
        
        
        
      
        
    }
    
    
}

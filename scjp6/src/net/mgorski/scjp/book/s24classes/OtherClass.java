package net.mgorski.scjp.book.s24classes;

import net.mgorski.scjp.book.s24classes.InnerClasses.TypicalInnerClass;


public class OtherClass {
    
    
    public static void main(String[] args) {
        InnerClasses ic = new InnerClasses();
//      InnerClasses.TypicalInnerClass tic = new TypicalInnerClass(); // not correct !
        
        ic.stringDefault = "3"; // the lowest we can access
        
        TypicalInnerClass inner = ic.createTypicalInner();
        inner.getSth(); // also here default is the lowest
        
        
        InnerClasses ic2 = new InnerClasses();
        TypicalInnerClass typicalInnerClass = ic2.new TypicalInnerClass(); // oh, lol-syntax
        TypicalInnerClass typicalInnerClass2 = new InnerClasses().new TypicalInnerClass(); // also ok
        
        ic2 = null; // nullify 
        System.out.println(typicalInnerClass.toString() + " of " + ic2); // ok
        
        
        
        
      
        
    }
    
    
}

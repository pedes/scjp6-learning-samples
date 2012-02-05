package net.mgorski.scjp.book.s24classes;

import java.io.Serializable;

public class InnerClasses {
    
    private String stringPrivate;
    protected String stringProtected;
    public String stringPublic;
    String stringDefault;
    
    
    public InnerClasses.TypicalInnerClass createTypicalInner(){
        TypicalInnerClass tic = new TypicalInnerClass();
        tic.getSthPrivate();    // also this !
        return tic;
    }
    
    
    public void normalInnerMethod() {

        int variable = 888; // inner-method variable
        final int finalVariable = 4444; // inner-method variable
        
//        InnerMethodClass imc = new InnerMethodClass();      // illegal
        
        abstract class InnerMethodClass {
            private int intPrv = 1;
            public int intPub = 1;
            int intDef = 1;
            protected int intPro = 1;
            
            void method(){
//                variable = 33; // cannot refer to non-final
                System.out.println(finalVariable);// but this is fine
            }
        }
        
        final class InnerMethodClassImpl extends InnerMethodClass implements Serializable {
            private static final long serialVersionUID = 1L;
        }
        
        InnerMethodClass imc = new InnerMethodClassImpl();      // ok here
        imc.intPrv = 1; // access to private members !
        
    }
    
    
    public void anonymousInner() {
        
        Serializable s = new Serializable() {
            private static final long serialVersionUID = 1L;
        };
        
        
        TypicalInnerClass tic = new TypicalInnerClass(){
          void doSth() {
              
          }
        };
        
        
        
        
    }
    
    
    void otherMethod(){
        TypicalInnerClass tic = new TypicalInnerClass();
        // InnerMethodClass - no access
    }
    
    class TypicalInnerClass {
        
        private String prv ="prv";
        
        public TypicalInnerClass() {
            stringPrivate = ""; // ok , this and all others!
        }
        
        private void getSthPrivate(){};
        protected void getSthProtected(){};
        public void getSthPublic(){};
        void getSth(){
             
            // access 
            System.out.println(this.prv);
            System.out.println(InnerClasses.this.stringDefault);    // and outer
            
            
        };
        
        
        
    }
}

package net.mgorski.scjp.book.s01varia;

import org.omg.CORBA.TRANSIENT;


public strictfp class S006OOtherModifiers {

    native synchronized  void methodInC(); // like abstract, no body
    
    private final void somethingFinalAndPrivate(){
        
    }
//    synchronized abstract void syncMe(); // not allowed with abstract!
    
    synchronized void syncMe(){ } ;;;; // mark no implementation
    
    
    strictfp long method(){ return 1L;}; 

    
    public void dupa( int dupa, String...strings ){
        
    }
}

package net.mgorski.scjp.book.s01varia;


public strictfp class S006OOtherModifiers {

    native void methodInC(); // like abstract
    
//    synchronized abstract void syncMe(); // not allowed with abstract!
    
    synchronized  void syncMe(){ } ;;;; // mark no implementation
    
    
    strictfp long method(){ return 1L;}; 

    
    public void dupa( int dupa, String...strings ){
        
    }
}

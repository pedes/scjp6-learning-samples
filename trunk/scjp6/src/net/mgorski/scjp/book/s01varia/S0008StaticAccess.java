package net.mgorski.scjp.book.s01varia;

public class S0008StaticAccess {
    
    public static void main(String[] args) {
        new S008Static.Dupa();   // correct to instanciate inner class w/o object of the parent
        
        // however, this will not compile
//        new S008Static.X();
        
        // this is correct again
        S008Static.X x = new S008Static().new X();
    }

}

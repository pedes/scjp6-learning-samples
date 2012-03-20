package net.mgorski.scjp.book.s01varia;

public class S008Static {

    CoffeeSize cs;
    S008Static.CoffeeSize cs2;
    S008Static.Dupa.CoffeeSize cs3; // requires name of the enclosing class
    
    private static int staticPrivateInt;
    static int defaultInt;
    public static int staticPublicInt;

    public S008Static() {
        // TODO Auto-generated constructor stub
    }

    private void go() {

        // static class Uuuu { // not allowed within method, wrong !!
        //            
        // }

        // enum CoffeeSize { BIG, HUGE, OVERWHELMING }; // wrong, cannot be local!!
        
    }
    // static class
    public static class Dupa {
        
        private void testAccess(){
            
            S008Static.staticPrivateInt = 3; // can access !!
            
            S008Static.defaultInt = 4; // can access as well
            
//            S008Static.cs;// cannot access
        }
        
        enum CoffeeSize {
            BIG, HUGE, OVERWHELMING
        } // mark no semicolon, ok !!
    }
    
    public class X {
        
    }

    // can be private
   private enum CoffeeSize {
        BIG, HUGE, OVERWHELMING
    }
   
   private int x;
}

/**protected cannot shrink visibility*/ enum CoffeeSize {
    BIG, HUGE, OVERWHELMING
};// optional semicolon

class Bla{
    
}




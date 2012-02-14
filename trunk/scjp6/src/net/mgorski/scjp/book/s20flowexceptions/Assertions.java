package net.mgorski.scjp.book.s20flowexceptions;

public class Assertions {
    
    
    /**
     * code works with
     * 
     * -enableassertions
     * -ea 
     * 
     */
    public static void main(String[] args) {
        assertionOne();
    }

    private static void assertionOne() {
        int x = -1;
        
        
        assert (x!=3); // ok
        
        assert (x >= 0) : "Bad condition put over x:"+x+", we want it to be negative"; // print assertion
        
        
        
        switch (x){
            case -1 : { System.out.println(""); } break;
            default : assert false : "How did you get here?!";
            
        }
        
    }
}

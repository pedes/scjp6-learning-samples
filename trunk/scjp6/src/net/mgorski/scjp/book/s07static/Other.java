package net.mgorski.scjp.book.s07static;

public class Other {
    
    static int k;
    
    public void doStuff() {
        k++;
        Other.k++;
        this.k++;   // this brings warningb, but still runs 
    }

}

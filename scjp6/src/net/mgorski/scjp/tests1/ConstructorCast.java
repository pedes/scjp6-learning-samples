package net.mgorski.scjp.tests1;

public class ConstructorCast {
    
    public ConstructorCast() {
        System.out.println("Constructor! ");
    }
    
    public static void main(String[] args) {
        Object o = new ConstructorCast();
        
        ConstructorCast c;
        
        System.out.println("blup");
        
        c = (ConstructorCast) o;
    }

}

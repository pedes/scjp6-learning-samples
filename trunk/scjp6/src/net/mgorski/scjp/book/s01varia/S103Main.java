package net.mgorski.scjp.book.s01varia;

public class S103Main {
    
    public static void main(String[] args) {
        
        
        S101Superclass s1 = new S101Superclass();
        S102Subclass s2 = new S102Subclass();
        
        S101Superclass s3 = new S102Subclass();
        
        
        System.out.println(s1.VAR);
        System.out.println(s2.VAR);
        System.out.println(s3.VAR);
        
        System.out.println(S102Subclass.VAR);
        System.out.println(S101Superclass.VAR);
        
    }

}

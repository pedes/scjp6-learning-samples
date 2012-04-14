package net.mgorski.scjp.book;

import net.mgorski.scjp.test3.SuperClass;

public class SubClass extends SuperClass {
    
    public int x = 10;
    
    public void bla(){
        System.out.println("this.x= "+x);
        System.out.println("super.x= "+super.x);
        this.x += 1;
    }
    
    public static void main(String[] args) {
        SuperClass sc = new SubClass();
        sc.bla();
        System.out.println(sc.x);
        
        System.out.println(new SubClass().x);
    }

}

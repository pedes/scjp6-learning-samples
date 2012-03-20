package net.mgorski.scjp.test2;

public class EmptyConstructor {
    
    public EmptyConstructor(String...s) {
        System.out.println("String");
        
    }
    
    public EmptyConstructor(Integer ... i){
        System.out.println("Integer");
    }
    
    public static void main(String[] args) {
//        new EmptyConstructor(); // will not compile !
    }

}

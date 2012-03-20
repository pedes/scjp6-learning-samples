package net.mgorski.scjp.test2;

public class Varargs {
    
    public static void method(int ... i){
        System.out.println("Small int");
    }
    
    public static void method(Integer ... i){
        System.out.println("Big int");
    }
    
    public static void main(String[] args) {
//         method (7);
//         method (new int[]{7,7});
        
        
    }
   

}

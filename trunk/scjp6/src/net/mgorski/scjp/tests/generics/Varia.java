package net.mgorski.scjp.tests.generics;


public class Varia {
    Object o = new Object();
    
    public static void main(String[] args) {

        label: // 1
        System.out.println("label");
        
        external: // 2
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                System.out.println("print!");
                continue external; //3
            }
            System.out.println("second");
        }
    
        boolean b1 = true;
        boolean b2 = false;
        
        if (b2 = b1){ //assignment 
            System.out.println("b2 is true!");
        }
        System.out.println("b2: "+b2);
    
        "1231312".length();
        System.out.println(new int[]{1});
        

        
        System.out.printf("%+-7d + %1$d", 123, 456);
    
           
       
    }
    
    public void sth(){
        synchronized (Object.class){
            
        } 
    }
    
    
}

package net.mgorski.scjp.old;

class Hexy {
    public static void main(String[] args) {
        Integer i = 42;
        String s = (i < 40) ? "life" : (i > 50) ? "universe" : "everything";
        System.out.println(s);
        
        int k =0;
        
        for (int j=0, n=0,w=0 ; j<10; j++){
            System.out.println("+"+j+n+w);
        }
    }
}
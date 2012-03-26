package net.mgorski.scjp.test2;

public class Scanner {
    public static void main(String[] args) {
        String context = "00000000100 00055       127 dd 222 6F (int)7";
        java.util.Scanner s = new java.util.Scanner(context);
        while (s.hasNextLong()) {
            System.out.print(s.nextLong() + ",");
        }
        
        s = new java.util.Scanner(context);
        
        System.out.println("----");
        while(s.hasNext()){
            System.out.print(s.next() + " ");
        }
    }
}

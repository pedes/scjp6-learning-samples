package net.mgorski.scjp.book.s01varia;

public class S011Octals {

    static byte c;
    public static void main(String[] args) {
        // int i = 01000000000000000000000000002;// out of range

        int i = 0202;
        int z = 0xDeadCafe;

        char x = 'x';
//        float f = 23.467890; // Compiler error, possible loss
        float g = 49837849.029847F; // OK; has the suffix "F"
        
        byte b1 = 127;
        byte b2 = -127;
        
        byte n = (byte)  g;
        
        float f = 32.3f;
        
        Float fl = new Float(49837849.029847);
        Float f1 = new Float(3.14f);
        Float f2 = new Float("3.14d");
        
        Double.parseDouble("22.2");
        fl.valueOf(f);

        

//        byte c = 128; // out of range

        

        System.out.println("val = " + i + "," + z+","+(x+i)+","+n+","+S011Octals.c);
        
        float [] xx = {22f};
        System.out.println("obj= "+(xx instanceof Object));

    }
}

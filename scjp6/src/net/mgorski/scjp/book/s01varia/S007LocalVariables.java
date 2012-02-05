package net.mgorski.scjp.book.s01varia;

public class S007LocalVariables {

    int a;
    // final int af; // do not allow default value for final
    final int af2 = 0;

    public void doMe() {
        int b; // not initialized (only warning) !!!!
        // af2 = 3; // cannot reassign WRONG!!

        System.out.println("read a = " + a);
        // System.out.println( "read a = " + b); // wrong !
    }

    public static void main(String[] args) {
        S007LocalVariables s = new S007LocalVariables();
        s.doMe();
    }

}

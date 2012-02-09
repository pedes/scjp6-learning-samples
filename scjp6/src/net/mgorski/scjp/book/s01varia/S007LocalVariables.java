package net.mgorski.scjp.book.s01varia;

public class S007LocalVariables {

    public S007LocalVariables() {
        x = 2;
        y = 3;
        // z is assigned
    }

    int a;
    // final int af; // do not allow default value for final
    final int af2 = 0;

    Object o1, o2;
    final int x, y, z = 2; // all final, last assigned

    int w;// gets default valu

    public void doMe() {
        int b; // not initialized (only warning) !!!!
        // af2 = 3; // cannot reassign WRONG!!

        System.out.println("read a = " + a);
        // System.out.println( "read a = " + b); // wrong !

        System.out.println(w);
    }

    public static void main(String[] args) {
        S007LocalVariables s = new S007LocalVariables();
        s.doMe();
    }

    int size = 27;
    String[][][][][] occupantName;
    String[] managerName [][][];


    public void setSize(int size) {
        size = size; //  -compiles
    }

}

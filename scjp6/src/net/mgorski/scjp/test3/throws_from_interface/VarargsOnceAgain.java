package net.mgorski.scjp.test3.throws_from_interface;

public class VarargsOnceAgain {

    static void doSth(int... a) {
        System.out.println("int...");
    }

    static void doSth(Integer... a) {
        System.out.println("Int...");
    }

    public static void main(String[] args) {
        Integer[] Ints = { new Integer(1), new Integer(2) };
        int ints[] = { 1, 2 };

        doSth(ints);
        doSth(Ints);
        
        //doSth(1); // cannot do because there are two methods

    }

}

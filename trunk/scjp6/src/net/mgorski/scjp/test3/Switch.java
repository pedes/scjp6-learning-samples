package net.mgorski.scjp.test3;

public class Switch {

    enum MEnum {
        A, B, C, D
    };

    public static void main(String[] args) {

        MEnum me = MEnum.A;
        int A = 99;
        int B = 98;
        int C = 97;
        switch (me) {
        default:
            System.out.print("Default "); // this will not be executed when any match found
        case A:
            System.out.print("Only A ");
        case B:
            System.out.print("Only B ");
        case C:
            System.out.println("Only C ");
        }
    }
}

package net.mgorski.scjp.book.s01varia;

public class S010EnumTester {

    public static void main(String[] args) {
        S009Enum enumBig = S009Enum.BIG;
        S009Enum enumSmall = S009Enum.SMALL;

        System.out.println(enumBig);
        System.out.println(enumBig.getSize());
        System.out.println(enumBig.getCode());

        System.out.println(enumSmall);
        System.out.println(enumSmall.getSize());
        System.out.println(enumSmall.getCode());
    }

}

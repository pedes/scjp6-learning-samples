package net.mgorski.scjp.book.s01varia;

import net.mgorski.scjp.book.s01varia.Sth.Suits;

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

        System.out.println(Suits.DIAMONDS);
        System.out.println(Suits.DIAMONDS.toString());
        System.out.println(Suits.DIAMONDS.toString().equals(Suits.DIAMONDS)); // false

        CasualEnum s = CasualEnum.A;
        System.out.println(s.getDeclaringClass());
        System.out.println(CasualEnum.valueOf("A"));
        try {
            System.out.println(CasualEnum.valueOf("DIAMONDS"));
        } catch (java.lang.IllegalArgumentException iae) {
            System.out.println("yes!");
        }
        
        
        for (CasualEnum ss : CasualEnum.values()){
            System.out.println("-"+ss);
        }
        
        System.out.println("ordinal of s "+s.ordinal());
        Class<?>[] interfaces = s.getClass().getInterfaces();
        for (Class<?> cc : interfaces){
            System.out.println(cc.getCanonicalName());
            
        }
        
        System.out.println("comparable?" + (s instanceof Comparable));
        
    }
}

package net.mgorski.scjp.book;

import java.util.Arrays;

public class ApiTester {

    class InnerClass {
        
        volatile int bla = 1;
//        final volatile int blaFinal = 1; // illegal
        
    }

    protected static class InnerStaticClass {
    }

    public static void main(String... args) {

        InnerStaticClass ic = new InnerStaticClass();
        
//        InnerClass ic2 = new InnerClass(); // wrong
        ApiTester.InnerClass ic2 = new ApiTester().new InnerClass(); // ok
        InnerClass ic3 = new ApiTester().new InnerClass(); // ok
        
        ApiTester.InnerStaticClass ic4 = new ApiTester.InnerStaticClass();
        
//        ApiTester.InnerStaticClass ic4 = ApiTester.new InnerStaticClass(); // wrong
        
        new Object();
        //new int [] { 0,0 }; // canot instanciate w/o object (valid for arrays)
        
        String java = "java";
        StringBuffer sbuf = new StringBuffer("java");
        StringBuilder sbld = new StringBuilder("java");
        
        System.out.println("buf == build? " +sbuf.equals(sbld));
        System.out.println("buf == string? " +sbuf.equals(java));
        System.out.println("string == buf? " +java.equals(sbld));
        System.out.println("string == buf.toString? " +java.equals(sbld.toString()));
        
        System.out.println(sbld.charAt(1));
        System.out.println(sbuf.charAt(0));
        System.out.println(java.charAt(0));
        
        
        int[] it = new int[][]{{0}}[0];
        System.out.println(it.toString());
        
        short s = 1; // legal
        byte b = 0x1; // legal
        byte b2 = 1; // legal
        
        char cc = (char)b;
        System.out.println("CHAR: " +cc);
        
        long l = 3l; // ok
        long l2 = 3;  
//        Long l3 = 3; // wrong
        Long l4 = 2L; // ok!
        
        float f = 3;
        float f1 = 3f;
//        float f2 = 3.2; // wrong, double
//        method(3);

        String str = "";
        str.length();
        
        StringBuilder sb = new StringBuilder(" ");
        
        System.out.println(sb.length());
    }
    
    static void method(short b){
        
    }

}

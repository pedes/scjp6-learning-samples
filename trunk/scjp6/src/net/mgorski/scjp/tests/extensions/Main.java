package net.mgorski.scjp.tests.extensions;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        ClassA a = new ClassA();

        try {
            a.aMethod(0, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ClassB b = new ClassB();
        b.aMethod(2F, 3f);
        
        ClassA i = new ClassB();
        try {
            i.aMethod(2F, 3f);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

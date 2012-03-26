package net.mgorski.scjp.test2;

import java.io.*;

public class SerializeAndDeserialize implements Serializable {

    int a = 1;
    static int b = 2;
    transient int c = 2;

    SerializeAndDeserialize(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static void main(String args[]) throws Exception {
        SerializeAndDeserialize ob1 = new SerializeAndDeserialize(4, 5, 6);
        new ObjectOutputStream(new FileOutputStream("A.ser")).writeObject(ob1);
        SerializeAndDeserialize ob2 = (SerializeAndDeserialize) new ObjectInputStream(
                new FileInputStream("A.ser")).readObject();
        System.out.print(ob2.a + " " + ob2.b + " " + ob2.c);
    }
}
package net.mgorski.scjp.test2;

import java.io.*;

public class SerializeAndDeserialize implements Serializable {

    int a = 1;
    static int b = 2;
    transient int c = 3;
    volatile int d = 4;

    private SerializeAndDeserialize(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public static void main(String args[]) throws Exception {
        SerializeAndDeserialize ob1 = new SerializeAndDeserialize(10, 11, 12, 13);
        SerializeAndDeserialize.b = 666; // !!! watch out on the exam !!! 
        new ObjectOutputStream(new FileOutputStream("A.ser")).writeObject(ob1);
        SerializeAndDeserialize ob2 = (SerializeAndDeserialize) new ObjectInputStream(
                new FileInputStream("A.ser")).readObject();
        System.out.print("instance:" +ob2.a + " static:" + ob2.b + " transient:" + ob2.c +" volatile:" + ob2.c);
    }
}
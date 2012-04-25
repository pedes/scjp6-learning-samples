package net.mgorski.scjp.test2;

import java.io.*;

public class SerializeAndDeserialize implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    int a = 1;
    static int b = 2;
    transient int c = 3;
    volatile int d = 4;
    transient int x1 = 5;
    transient int x2 = 5;

    public SerializeAndDeserialize() {

        x2 = 6;
    }

    private SerializeAndDeserialize(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public static void main(String args[])  {
        SerializeAndDeserialize ob1 = new SerializeAndDeserialize(10, 11, 12, 13);
        SerializeAndDeserialize.b = 666; // !!! watch out on the exam !!!
        try {
            new ObjectOutputStream(new FileOutputStream("A.ser")).writeObject(ob1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SerializeAndDeserialize ob2;
        try {
            ob2 = (SerializeAndDeserialize) new ObjectInputStream(
                    new FileInputStream("A.ser")).readObject();
            
            System.out.print("instance:" + ob2.a + " static:" + ob2.b + " transient:" + ob2.c
                    + " volatile:" + ob2.c);
            System.out.println("\n\nx1:" + ob2.x1 + " x2:" + ob2.x2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
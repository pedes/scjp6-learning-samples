package net.mgorski.scjp.test2;

import java.io.*;

class AA {
}

class BB extends AA {
}

class CC extends AA implements Serializable {
}

final class DD extends BB {
}

public class Refcast {
    public static void main(String args[]) {
        AA a = new AA();
        BB b = new BB();
        CC c = new CC();
        DD d = new DD();
        Object ob = c; // Line-1
        d = (DD) ob; // Line-2
        d = (DD) new BB(); // Line-3
        // c = (C) new Serializable() { // does not compile here
        // }; // Line-4
    }
}

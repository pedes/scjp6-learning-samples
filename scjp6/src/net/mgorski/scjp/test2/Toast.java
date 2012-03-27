package net.mgorski.scjp.test2;

// example comes from http://www.certpal.com/

class Devil {
    public Devil() {
        System.out.print("devil ");
    }

    public Devil(Toast eye) {
    }

}

class Boast extends Devil {
    public Boast() {
        System.out.print("boast ");
    }

    public Boast(Toast eye) {
    }

}

public class Toast extends Boast {
    public static void main(String... args) {
        Toast toast = new Toast();
        System.out.println(",");
        new Devil(toast);
        System.out.println(",");
        new Boast(toast);
        System.out.println(",");
        new Toast();
    }
}
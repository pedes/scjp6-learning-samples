package net.mgorski.scjp.book.s01varia;

public class S012Boxing {

    public void print(Throwable t, Object... o) {
        System.out.println("Throwable + Object ");
    }

    public void print(Object... o) {
        System.out.println("Object");
    }

    public static void main(String[] args) {
        NullPointerException npe = new NullPointerException();
        new S012Boxing().print(npe, npe);
    }

   
}
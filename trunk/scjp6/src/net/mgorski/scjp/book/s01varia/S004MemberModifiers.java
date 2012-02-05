package net.mgorski.scjp.book.s01varia;

public class S004MemberModifiers {

    private int a = 0;
    public int b = 1;

    protected void dupa() {
        System.out.println("DUPA = " + a + "," + b);
        a++;

    }

    public static void main(String[] args) {
        Ext e = new Ext();
        e.doSth();
    }
}

class Ext extends S004MemberModifiers {

    public void doSth() {
        dupa();

    }

}

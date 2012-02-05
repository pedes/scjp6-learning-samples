package net.mgorski.scjp.book.s01varia;

public class S005DefaultMemberAccessSamePkg {

    public static void main(String[] args) {

        S005DefaultMemberAccess dm = new S005DefaultMemberAccess();
        dm.testDefault();
        dm.testProtect();
        dm.testPublic();

        System.out.println("ALL ok");
    }

}

package net.mgorski.scjp.book.s02memberaccess;

import net.mgorski.scjp.book.s01varia.S005DefaultMemberAccess;

public class S005Extension extends S005DefaultMemberAccess {

    @Override
    protected void testProtect() {
        // TODO Auto-generated method stub
        super.testProtect();
    }
    // !!!! testDefault not visible
}

class S005Test {

    public static void main(String[] args) {
        S005DefaultMemberAccess dm = new S005DefaultMemberAccess();
        try {
            dm.testPublic(); // the only one visible
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

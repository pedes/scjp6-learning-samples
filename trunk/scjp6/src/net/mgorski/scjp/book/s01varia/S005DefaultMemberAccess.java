package net.mgorski.scjp.book.s01varia;

public class S005DefaultMemberAccess {

    public void testPublic() {
    };

    protected void testProtect() {
    };

    private void testPriv() {
    };

    void testDefault() {
    };
}

class Extension extends S005DefaultMemberAccess {

    @Override
    void testDefault() {
        // TODO Auto-generated method stub
        super.testDefault();
    }

    @Override
    protected void testProtect() {
        // TODO Auto-generated method stub
        super.testProtect();
    }

    protected int testPriv() {
        return 0;
    } // OK!

}

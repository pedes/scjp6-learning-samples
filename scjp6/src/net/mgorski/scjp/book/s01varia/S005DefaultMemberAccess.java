package net.mgorski.scjp.book.s01varia;

import net.mgorski.scjp.book.s01varia.subpackage.S005DifferentPackage;

public class S005DefaultMemberAccess {

    public void testPublic() {
    };

    protected void testProtect() {
    };

    private void testPriv() {
    };

    
    void /* default access */ testDefault() {
    };
    
    public static void main(String[] args) {
        S005DifferentPackage o = new S005DifferentPackage();
//        o.defaultMember(); // WRONG, default acces and different package!
    }
}




class ExtSubpakcage extends S005DifferentPackage{
    public void sth(){
//        defaultMember(); // cannot be called neither (different package)
        S005DefaultMemberAccess o = new S005DefaultMemberAccess();
        o.testProtect(); // also ok, because the same package!
    }
}
class Extension extends S005DefaultMemberAccess {

    @Override
    void testDefault() {
        super.testDefault(); // ok, because the same package
    }

    @Override
    protected void testProtect() {
        super.testProtect();
    }

    protected int testPriv() {
        return 0;
    } // OK!
}


abstract class ClassA {
    protected abstract  void  doSth();
    public synchronized void sthSync(){
        
    }
}

abstract class ClassB extends ClassA{
// abstract void doSth();   // optional
    
}

class ClassC extends ClassA {
    
    // cannot decrease visibility 
    
    @Override
    protected void doSth() {
        // impl
    }
}



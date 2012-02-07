package net.mgorski.scjp.book.s01varia.subpackage;

import net.mgorski.scjp.book.s01varia.S005DefaultMemberAccess;

public class S005DifferentPackage extends S005DefaultMemberAccess {
    
    void defaultMember(){
        //
    }

    void accesstest(){
        S005DefaultMemberAccess o = new S005DefaultMemberAccess();
//        o.testProtect(); // wrong, different pkg
        
        this.testProtect(); //OK
//        this.testDefault();// not

         
//        
    }
}

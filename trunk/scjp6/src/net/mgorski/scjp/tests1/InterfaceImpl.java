package net.mgorski.scjp.tests1;

import net.mgorski.scjp.tests1.subpackage.Interface;

public class InterfaceImpl implements Interface {
    
    public static void main(String[] args) {
        Interface i = new InterfaceImpl();
        
        // cannot be assigned
//        i.HU2 = 2;
        
        System.out.println(Interface.HU2);
    }

}

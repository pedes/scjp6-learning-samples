package net.mgorski.scjp.test3;

import java.io.Serializable;

public class VariousGenerics<EXT extends B> {

    static transient int xyz = 0; // static implicitly transient
    
    public <T extends EXT> VariousGenerics<? super T> getVal(VariousGenerics<? super T> t) {
        return t;
    }

    public EXT getVal2(EXT t) {
        return t;
    }

    public static void main(String[] args) {

        // new VariousGenerics<A>(); // wrong
        VariousGenerics<B> vg = new VariousGenerics<B>();
        VariousGenerics<B> vb = new VariousGenerics<B>();

//        B val2 = vb.getVal2(new C());
//        val2 = vb.getVal2(new B());

        vg.getVal(vb);
        
        
        // bonus
        A a = new A();
        final String[] arr = {"1","2"};
        System.out.println(a instanceof IX);
        System.out.println(arr instanceof Object);
        
        C c = new C();
        B b = new B();
//        System.out.println(b instanceof IX);//bla
        System.out.println(c instanceof IX);
        
        
        Comparable cc = (Comparable)(Serializable)(Iterable) c; // valid at compile time

    }
}

class A {
}

class B extends A {
};

class C extends B implements IX{
};


interface IX {
}
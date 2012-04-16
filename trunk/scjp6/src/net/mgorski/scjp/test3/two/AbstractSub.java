package net.mgorski.scjp.test3.two;

public abstract class AbstractSub extends Sub {
    
    @Override
    public abstract Sub method1(); // this method is abstract even if it was not in the super-class

}

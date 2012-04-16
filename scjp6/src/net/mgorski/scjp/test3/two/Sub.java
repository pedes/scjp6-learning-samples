package net.mgorski.scjp.test3.two;

public class Sub extends Super {

    @Override
    // changed return type to super class
    public Sub method1() throws SuperException {
        return null;
    }

    @Override
    public Sub method2() throws SubException {
        return null;
    }

    @Override
    public Sub method3() throws SuperException {
        return null;
    }

    @Override
    public Sub method4() /* throws SuperException cannot throw exception higher in the rank !!! */{
        return null;
    }

}

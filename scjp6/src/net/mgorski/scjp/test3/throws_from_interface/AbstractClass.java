package net.mgorski.scjp.test3.throws_from_interface;

import java.text.ParseException;

public abstract class AbstractClass implements Interface {

    @Override
    public abstract void doSth() throws ParseException;

}

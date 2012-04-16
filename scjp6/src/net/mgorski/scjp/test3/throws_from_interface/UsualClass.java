package net.mgorski.scjp.test3.throws_from_interface;

import java.io.IOException;
import java.text.ParseException;

public class UsualClass extends AbstractClass implements Interface{

    @Override
    public void doSth() throws ParseException/* , ClassCastException*/ {

    }

}

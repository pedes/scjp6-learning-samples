package net.mgorski.scjp.test3.throws_from_interface;

import java.io.IOException;
import java.text.ParseException;

public interface Interface {

    void doSth() throws IOException, ParseException;

}

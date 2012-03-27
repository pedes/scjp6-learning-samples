package net.mgorski.scjp.test2;

public class FinalizeMethod extends Object implements MyInterface // #1
{
    public static void main(String[] args) throws Throwable // #2
    {
        MyInterface interface1 = new FinalizeMethod();
        interface1.finalize(); // #3
    }

    public void finalize() throws Throwable // #4
    {
        super.finalize(); // #5
    }
}

abstract interface MyInterface {
    void finalize() throws Throwable; // #6
}
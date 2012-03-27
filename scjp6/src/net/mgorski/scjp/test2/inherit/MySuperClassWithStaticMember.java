package net.mgorski.scjp.test2.inherit;

public class MySuperClassWithStaticMember implements Int1{
    
    public static int returnNumber() {
        return 0;
    }

    @Override
    public void go() {
        System.out.println("go int1");
    }

}

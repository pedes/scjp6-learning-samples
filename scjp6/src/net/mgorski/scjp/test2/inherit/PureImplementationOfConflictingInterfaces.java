package net.mgorski.scjp.test2.inherit;

public class PureImplementationOfConflictingInterfaces implements Int1, Int2{
    
    public static void main(String[] args) {
     new PureImplementationOfConflictingInterfaces().go();   
    }

    @Override
    public void go() {
        System.out.println("go!");
        
    }

}

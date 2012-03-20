package net.mgorski.scjp.test2;

class OuterClass {
    
    private int x;
    public static class StaticInnerClass {
//        x=2;// bad!
    }

    private final class InnerClass {
        public InnerClass() {
            x = 23; // ok
        }
    }

    public static void main(String[] args) {
        new StaticInnerClass(); // ok
        OuterClass oc = new OuterClass();
//        oc.new StaticInnerClass(); // will not compile, cannot create static class out of instance of the outer
        
        oc.new InnerClass(); // ok
        System.out.println(oc.x);
    }

}

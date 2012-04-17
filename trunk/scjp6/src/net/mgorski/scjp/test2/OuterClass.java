package net.mgorski.scjp.test2;

class OuterClass  {
    
    public class InnerPublicClass{
        public volatile int x;
    }
    
    protected static class InnerProtectedStatic{
        public int xy;
    }
    
    private transient int x;
    private static int xStatic;
    
    // anonymous inner class implemented outside inner method/class
    private Runnable r = new Runnable() {
        
//        public Runnable(){ // cannot define constructor
//            
//        }
        
        @Override
        public void run() {
            
            InnerPublicClass inc = new InnerPublicClass();
            System.out.println(inc.x);
            
            
            
        }
    };
    
    public static class StaticInnerClass extends OuterClass {
//        x=2;// bad!
        
        static void bla() throws Exception { //static method ok
            xStatic = 3;
            
        }
    }
    
    private void outerMethod(){
         class AnonymousOuter extends StaticInnerClass {
            public AnonymousOuter(int x) {
            }
            
            void x(){}// not allowed
        }
        
        AnonymousOuter ao = new AnonymousOuter(2); 
    }

    private final class InnerClass extends OuterClass  {
        public InnerClass() {
            x = 23; // ok
        }
        
//        static void n(){}
    }

    public static void main(String[] args) {
        new StaticInnerClass(); // ok
        OuterClass oc = new OuterClass();
//        oc.new StaticInnerClass(); // will not compile, cannot create static class out of instance of the outer
        
        oc.new InnerClass(); // ok
        System.out.println(oc.x);
        
        
        class InMethod {
            
        }
        
       class InMethodExtension extends InMethod {
            
            /*static cannot be static!!!*/ void method(){
                InnerPublicClass ipc = new OuterClass().new InnerPublicClass();
            }
            
        }
    }

}

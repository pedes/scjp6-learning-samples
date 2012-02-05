package net.mgorski.scjp.book.s24classes;

public /*static cannot ! */class StaticNestedOuter {
    
    static int staticMember = 1;
    int instanceMember = 2;
    
    
    private void method() {
        

        StaticInner sin = new StaticInner();
        sin.instanceInnerMember = 2;


    }
    
    
    public static class StaticInner {
        
        static int staticInnerMember = 1;
        int instanceInnerMember = 2;
        
        static void doStaticStuff(){
            
            staticInnerMember = 1;
            staticMember =78;
            
        }
        
        
        void itsNotStatic() {
            
            StaticNestedOuter.StaticInner ssss = new StaticInner();
            ssss.instanceInnerMember=3;
            
            
        }
    }
}

package net.mgorski.scjp.test2.inherit;

public class MySubclassWithStaticMember extends MySuperClassWithStaticMember implements Int2{
    
    @Override
    public void go() {
        System.out.println("go int2");
    }
    
    public static int returnNumber(){
        return 2;
    }
    
    public static void main(String[] args) {
        System.out.println(MySuperClassWithStaticMember.returnNumber());
        System.out.println(MySubclassWithStaticMember.returnNumber());
        
        MySuperClassWithStaticMember sub = new MySubclassWithStaticMember();
        System.out.println(sub.returnNumber());
        
        sub.go();
        
    }

}

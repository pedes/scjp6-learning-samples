package net.mgorski.scjp.test3.two;

public class Super {

    public Super method1() throws SuperException {
        return null;
    }

    public Super method2() throws SubException {
        return null;
    }
    
    public Sub method3() throws SuperException {
        return null;
    }

    public Sub method4() throws SubException {
        return null;
    }

    
    public static void main(String[] args) {
        if (true){
            try {
                throw new Throwable();
            } catch (Throwable e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        if (true){
            throw new MyError();
        }
    }
}

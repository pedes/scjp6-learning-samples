package net.mgorski.scjp.book.s06downcast;

public class HomoSappiens extends Homo {
    
    @Override
    public HomoSappiens createInstance() {
        return new HomoSappiens();
    }
    
    public int foo() {
        char c = 'c';
        return c; 
    }
    
//    public int fooBar() {
//        long notConvertable = 33;
//        return notConvertable;            // CANNOT DOWNCAST!
//    }
    
    
    public void playWithBall(){
        // play with ball here
        return ;
    }
    
    public Homo createHomo() {
        return new HomoSappiens();
    }

}

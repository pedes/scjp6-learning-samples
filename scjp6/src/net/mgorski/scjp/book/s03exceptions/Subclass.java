package net.mgorski.scjp.book.s03exceptions;

public class Subclass extends Class {
    
    protected /*legal!*/ Subclass() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    /**
     * Can be public, protected
     * Can throw no exceptions, or SUBCLASSES OF ArrayOutofBoundzs
     * 
     * CANNOT BE default, private !!
     * CANNOT THROW ANY BROADER EXCEPTIONS
     */
    public int foo(int u)  {
        System.out.println(u);
        return 1;
    }
}

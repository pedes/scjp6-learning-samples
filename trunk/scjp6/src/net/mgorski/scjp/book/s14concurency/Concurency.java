package net.mgorski.scjp.book.s14concurency;

import junit.framework.TestCase;

import java.util.concurrent.locks.ReentrantLock;

public class Concurency extends TestCase {
    
    
    private ReentrantLock lock = new ReentrantLock();
    
    public void testLock() {
        
        try {
            lock.lock();
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        
        
    }
    
}

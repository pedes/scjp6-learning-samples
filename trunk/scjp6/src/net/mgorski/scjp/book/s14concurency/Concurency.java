package net.mgorski.scjp.book.s14concurency;

import java.util.concurrent.locks.ReentrantLock;

import junit.framework.TestCase;

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

package io.zipcoder;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier{
    Lock lock = new ReentrantLock(); 
    
    public SafeCopier(String toCopy) {
        super(toCopy);
    }

    public synchronized void run() {
       lock.lock();
        while (stringIterator.hasNext()) {
            copied += stringIterator.next() + " ";
        }
    }
}

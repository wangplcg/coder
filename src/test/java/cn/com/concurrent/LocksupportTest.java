package cn.com.concurrent;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 * User: wangpl
 * Date: 2020-05-26
 * Time: 11:17
 */

public class LocksupportTest {

    @Test
    public void testLookSupport() throws InterruptedException {
        LockSupport.park();
        LockSupport.unpark(Thread.currentThread());
    }

    @Test
    public void testInterrupt() {
        ReentrantLock reentrantLock = new ReentrantLock();
        try {
            reentrantLock.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread.interrupted();


    }
}
package cn.com.thread;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 * User: wangpl
 * Date: 2019-08-05
 * Time: 14:26
 */

public class TestThreadInterrupt {

    @Test
    public void testInterrupt(){
        Object mutex = new Object();

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                 try {
                     Thread.sleep(200);
                     // synchronized (mutex) {
                        System.out.println("线程 " + Thread.currentThread().getName() + "正在运行");
                     // }
                 } catch (InterruptedException e) {
                     System.out.println(Thread.currentThread().isInterrupted());
                 }
            });
            thread.start();
        }

    }

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(() -> {
                try {
                    lock.lockInterruptibly();
                    Thread.sleep(5000);
                    System.out.println("线程 " + Thread.currentThread().getName() + "正在运行");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(Thread.currentThread().isInterrupted());
                } finally {
                    lock.unlock();
                }
            });
            thread.start();
            if (i == 1) {
                thread.interrupt();
            }
        }
    }
}

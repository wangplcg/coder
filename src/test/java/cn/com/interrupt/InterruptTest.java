package cn.com.interrupt;

import org.junit.Test;

/**
 * @Classname InterruptTest
 * @Description TODO
 * @Date 2021/7/10 20:59
 * @Created by think
 */
public class InterruptTest {

    @Test
    public void testInterrupt() {
        Thread t = new Thread(() -> {
            while (!Thread.interrupted()) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("interrupted():: " + Thread.interrupted());
                    Thread.currentThread().interrupt();
                }
            }
        });
        t.start();
        t.interrupt();
        System.out.println("interrupted():: " + Thread.interrupted());
        try {
            t.join();
        } catch (InterruptedException e) {
            System.out.println("interrupted():: " + Thread.interrupted());
            e.printStackTrace();
        }
    }


}

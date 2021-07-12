package cn.com.sychronized;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname TestSychronized
 * @Description TODO
 * @Date 2021/5/14 23:08
 * @Created by think
 */
public class TestSychronized {
    private AtomicInteger atomicInteger;

    public static void main(String[] args) {
        testA();
        testB();
    }


    public static synchronized void testA() {
        System.out.println("test sychronized in method");
    }

    public static void testB() {
        synchronized (TestSychronized.class) {
            System.out.println("test sychronized in method");
        }
    }
}

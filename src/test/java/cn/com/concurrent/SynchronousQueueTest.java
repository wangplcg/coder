package cn.com.concurrent;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * Description:
 * User: wangpl
 * Date: 2020-05-26
 * Time: 11:17
 */

public class SynchronousQueueTest {

    @Test
    public void testSynchronousQueue() throws InterruptedException {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();
        int threadnums = 5;
        CountDownLatch countDownLatch = new CountDownLatch(threadnums);

        for (int i = 0; i < threadnums; i++) {
            int finalI = i;
            new Thread(()->{
                try {
                    countDownLatch.countDown();
                    queue.put(finalI);
                    System.out.println(finalI + "--");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        ExecutorService executorService = Executors.newCachedThreadPool();
        SynchronousQueue synchronousQueue = new SynchronousQueue();
        synchronousQueue.take();
        countDownLatch.await();
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
    }
}
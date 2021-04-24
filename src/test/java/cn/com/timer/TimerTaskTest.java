package cn.com.timer;

import io.netty.util.HashedWheelTimer;
import org.apache.commons.collections4.map.HashedMap;
import org.junit.Test;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

/**
 * Description:
 * User: wangpl
 * Date: 2020-07-07
 * Time: 16:01
 */

public class TimerTaskTest {

    @Test
    public void timerTest() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("timer 输出");
            }
        }, 200, 2000);
        countDownLatch.await();

        HashedWheelTimer hashedWheelTimer = new HashedWheelTimer();


    }
}
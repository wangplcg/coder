package cn.com.guava;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

/**
 * Description:
 * User: wangpl
 * Date: 2019-07-04
 * Time: 9:30
 */

public class ReteLimiterTest {

    @Test
    public void testLimit() throws InterruptedException {
        RateLimiter limiter = RateLimiter.create(10);
        long start = System.currentTimeMillis();
        for (int i= 0; i < 30; i++) {
            double time = limiter.acquire();
            long after = System.currentTimeMillis() - start;
            if (time > 0D) {
                System.out.println(i + ",limited,等待:" + time + "，已开始" + after + "毫秒");
            } else {
                System.out.println(i + ",enough" + "，已开始" + after + "毫秒");
            }
            //模拟冷却时间，下一次loop可以认为是bursty开始
            if (i == 9) {
                Thread.sleep(2000);
            }
        }
        System.out.println("total time：" + (System.currentTimeMillis() - start));
    }
}

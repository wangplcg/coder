package cn.com.redisson;

/**
 * Description:
 * User: wangpl
 * Date: 2019-07-08
 * Time: 18:39
 */

public class LockTest {

    public static void main(String[] args) throws InterruptedException {
        DistributedRedisLock.acquire("123123");
        //执行具体业务逻辑
        Thread.sleep(10000);
        //释放锁
        DistributedRedisLock.release("123123");
    }
}

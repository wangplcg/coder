package cn.com.lambda;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * Description:
 * User: wangpl
 * Date: 2019-06-24
 * Time: 22:06
 */

public class ConsumerTest {

    @Test
    public void testConsumer() {
        Consumer f = System.out::println;
        Consumer f2 = n -> System.out.println(n + "-F2");

        //执行完F后再执行F2的Accept方法
//        f.andThen(f2).accept("test");

        //连续执行F的Accept方法
        f.andThen(f).andThen(f).andThen(f2).accept("test1");
    }
}

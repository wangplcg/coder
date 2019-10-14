package cn.com.netty.fast;

import io.netty.util.concurrent.FastThreadLocal;

/**
 * Description:
 * User: wangpl
 * Date: 2019-08-11
 * Time: 11:30
 */

public class FastThreadLocalTest {

    private static FastThreadLocal<Object> threadLocal = new FastThreadLocal<Object>() {
        @Override
        protected Object initialValue() throws Exception {
            return new Object();
        }
    };

    public static void main(String[] args) {
        new Thread(() -> {
            Object object = threadLocal.get();
            System.out.println(object);
        }).start();


        new Thread(() -> {
            Object object = threadLocal.get();

            System.out.println(object);
        }).start();
    }


}

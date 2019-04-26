package cn.com.aop;

import org.springframework.aop.ThrowsAdvice;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Think
 * Date: 2019-02-28
 * Time: 17:29
 */

public class ThrowTest implements ThrowsAdvice {


    public void afterThrowing(Exception ex) {
        System.out.println("aaa");
    }
}

package cn.com.aop;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Think
 * Date: 2019-02-27
 * Time: 23:01
 */

public interface IStudent {
    void test(String a) throws Exception;

    void testArray(String[] a, String b) throws Exception;

    void testArrayVar(String... a) throws Exception;
}

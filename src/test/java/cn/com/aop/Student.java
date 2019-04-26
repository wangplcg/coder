package cn.com.aop;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Think
 * Date: 2019-02-27
 * Time: 22:59
 */

public class Student implements IStudent {

    @Override
    public void test(String a) throws Exception {
        throw new Exception("aaaa");
    }

    @Override
    public void testArray(String[] a, String b) throws Exception {

    }

    @Override
    public void testArrayVar(String... a) throws Exception {

    }
}

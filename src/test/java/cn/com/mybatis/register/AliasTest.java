package cn.com.mybatis.register;

import cn.com.jdbc.Customer;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Description:
 * User: wangpl
 * Date: 2020-01-18
 * Time: 11:23
 */

public class AliasTest {

    @Test
    public void test() {
        System.out.println(Customer.class.toString());
        assertThat("1", equalTo("2"));
    }
}

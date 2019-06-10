package cn.com.guava;

import com.google.common.base.CaseFormat;
import org.junit.Test;

/**
 * Description:
 * User: wangpl
 * Date: 2019-06-10
 * Time: 14:51
 */

public class CaseFormatTest {

    @Test
    public void testCaseFormat(){
        String data = "test_data";
        System.out.println(CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, "test-data"));
        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "test_data"));
        System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "test_data"));
    }
}

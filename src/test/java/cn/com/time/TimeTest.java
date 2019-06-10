package cn.com.time;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;

/**
 * Description:
 * User: wangpl
 * Date: 2019-05-28
 * Time: 18:55
 */

public class TimeTest {
    @Test
    public void timeTest() {
        // 获取登记日期距今时间差
        DateTime djDateTime = DateTime.parse("2019-05-14", DateTimeFormat.forPattern("yyyy-MM-dd"));
        boolean afterNow = djDateTime.plusDays(15).isAfterNow();
        System.out.println(afterNow);
    }
}

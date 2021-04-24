package cn.com.code;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.tuple.Pair;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Period;

/**
 * Description:
 * User: wangpl
 * Date: 2020-10-20
 * Time: 16:42
 */

public class LocalDateTimeTest {

    @Test
    public void testLocalDate() {

        LocalDateTime localDateTime = LocalDateTime.now();
        //当前时间加上25小时３分钟
        LocalDateTime inTheFuture = localDateTime.plusHours(25).plusMinutes(3);
        System.out.println(inTheFuture);
        // 同样也可以用在localTime和localDate中
        System.out.println(localDateTime.toLocalTime().plusHours(25).plusMinutes(3));
        System.out.println(localDateTime.toLocalDate().plusMonths(2));
        // 也可以使用实现TemportalAmount接口的Duration类和Period类
        System.out.println(localDateTime.toLocalTime().plus(Duration.ofHours(25).plusMinutes(3)));
        System.out.println(localDateTime.toLocalDate().plus(Period.ofMonths(2)));

        Instant instant = Instant.now();
        System.out.println(instant);
    }


    @Test
    public void testDateTime() {
        DateTime dateTime = new DateTime(DateTimeZone.forOffsetHours(8)).withHourOfDay(22).withMinuteOfHour(0);
        boolean after = DateTime.now(DateTimeZone.forOffsetHours(8)).isAfter(dateTime);
        System.out.println(dateTime.getMillis());
        System.out.println(DateTime.now(DateTimeZone.forOffsetHours(8)).getMillis());
    }
}

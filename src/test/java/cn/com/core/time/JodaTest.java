package cn.com.core.time;

import org.joda.time.DateTime;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Think
 * Date: 2019-04-10
 * Time: 11:04
 */

public class JodaTest {
    @Test
    public void jodaTest() {
        DateTime dateTime = new DateTime();
        System.out.println(dateTime.toString("yyyy-MM-dd"));

        String[] dlDmArray = new String[]{"030000", "040000" ,"050000" ,"060000"};

    }

    @Test
    public void calenerTest() {
        String endDate = getEndDate();
        System.out.println(endDate);
    }

    public String getEndDate() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.MONTH, -6);
        Date beforeTime = ca.getTime();

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        final int last = cal.getActualMinimum(Calendar.DAY_OF_YEAR);
        cal.set(Calendar.DAY_OF_YEAR, last);
        Date yearFirstTime = cal.getTime();
        // 如果之前时间为 年第一天之前（去年情况）返回年第一天
        if (beforeTime.compareTo(yearFirstTime) < 0) {
            return df.format(yearFirstTime);
        }
        return df.format(beforeTime);
    }
}
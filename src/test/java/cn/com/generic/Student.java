package cn.com.generic;


import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * Description:
 * User: wangpl
 * Date: 2020-01-08
 * Time: 22:30
 */
public class Student {

    @Test
    public void test() {
        int count= 0;

        for (int i = 1; i <= 31; i++) {
            for (int j = 1; j < 13; j++) {
                if (j != 1 && j != 3 && j != 5 && j != 7 && j != 8 && j != 10 && j != 12) {
                    if (i == 31) {
                        continue;
                    }
                }
                if (j == 2) {
                    if (i > 28) {
                        continue;
                    }
                }
                String d = StringUtils.leftPad(i + "", 2, '0');
                String m = StringUtils.leftPad(j + "", 2, '0');
                String y = StringUtils.reverse(m + d);
                if (Integer.valueOf(y) > 2100 || Integer.valueOf(y) < 2000) {
                    continue;
                }
                System.out.println(y  + ":" + m + d);
                count ++;
            }
        }
        System.out.println(count);
    }
}
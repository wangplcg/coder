package cn.com.guava;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.List;

/**
 * Description:
 * User: wangpl
 * Date: 2019-06-10
 * Time: 14:33
 */

public class SpliterTest {

    @Test
    public void testSpliterStr() {
        List<String> strings = Splitter.on("#").trimResults().splitToList("123#    456#789");
        System.out.println(strings);

        List<String> str = Splitter.on("#").splitToList("123#    456#789");
        System.out.println(str);

        List<String> strS = Splitter.on("#").trimResults(CharMatcher.anyOf(". ")).splitToList("123...#  ..  456#...789..");
        System.out.println(strS);
    }
}

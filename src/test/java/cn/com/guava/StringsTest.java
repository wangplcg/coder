package cn.com.guava;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import org.junit.Test;

import java.util.List;

/**
 * Description:
 * User: wangpl
 * Date: 2019-06-10
 * Time: 14:04
 */

public class StringsTest {

    @Test
    public void testStrings() {
        String wang = Strings.padEnd("wang", 10, '!');
        System.out.println(wang);
    }

    @Test
    public void testStream() {
        List<Integer> ints = Lists.newArrayList(1,2,3,4,5,6,7,8,9,10);
        System.out.println("ints sum is:" + ints.stream().reduce(0, (sum, item) -> sum + item));
    }

    @Test
    public void testInts() {
        List<Integer> integers = Ints.asList(1, 2, 3, 4, 5, 6, 7, 8);
    }
}
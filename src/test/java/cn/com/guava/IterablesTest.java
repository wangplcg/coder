package cn.com.guava;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import org.junit.Test;

/**
 * Description:
 * User: wangpl
 * Date: 2019-06-10
 * Time: 14:54
 */

public class IterablesTest {

    @Test
    public void testIterables(){
        Iterable<String> filter = Iterables.filter(ImmutableList.of("123", "123", "123", "123"), "123"::equals);
        for (String s : filter) {
            System.out.println(s);
        }
    }
}
package cn.com.guava;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

/**
 * Description:
 * User: wangpl
 * Date: 2019-06-10
 * Time: 14:10
 */

public class ImmutableTest {

    public void listTest() {
        ImmutableList<String> of = ImmutableList.of("red", "green", "black", "white", "grey");
    }

    public void mapTest() {
        ImmutableMap<String, String> of = ImmutableMap.of("red", "green", "black", "white");
    }


}

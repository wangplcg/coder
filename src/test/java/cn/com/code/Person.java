package cn.com.code;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URLEncoder;

/**
 * Description:
 * User: wangpl
 * Date: 2020-11-24
 * Time: 11:29
 */

public interface Person<T, D> {

    default void getClassInfo() {
        System.out.println(URLEncoder.encode("##%%————"));
    }

}

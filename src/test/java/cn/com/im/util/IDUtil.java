package cn.com.im.util;

import java.util.UUID;

/**
 * Description:
 * User: wangpl
 * Date: 2019-08-13
 * Time: 19:06
 */

public class IDUtil {

    /**
     * 生成Id
     * @return
     */
    public static String generateId() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10);
    }
}

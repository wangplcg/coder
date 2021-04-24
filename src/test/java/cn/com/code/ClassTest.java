package cn.com.code;

import java.net.URLEncoder;

/**
 * Description:
 * User: wangpl
 * Date: 2020-11-24
 * Time: 11:29
 */

public class ClassTest {

    public static void main(String[] args) {
        System.out.println(generatePublishId("sceneName", "boName"));
    }

    public static String generatePublishId(String sceneName, String boName) {
        return String.format("%s_%s_%s_%d", sceneName, boName, "P", System.currentTimeMillis());
    }

}

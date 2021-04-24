package cn.com.algorithm.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description:
 * User: wangpl
 * Date: 2020-06-21
 * Time: 11:02
 */

public class geek {

    public static void main(String[] args) {
        String content = "http://www.baidu.com:443//123213/com";
        String pattern = "http(s)?://.*?/";

        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(content);
        if (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }
}

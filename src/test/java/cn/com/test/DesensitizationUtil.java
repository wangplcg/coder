package cn.com.test;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description:
 * User: wangpl
 * Date: 2019-10-24
 * Time: 22:39
 */

public class DesensitizationUtil {
    private static Pattern PatternPercent = Pattern.compile("偷税数额占应纳税额10%");

    private static Pattern PatternJe = Pattern.compile("偷税数额为\\d+(\\.\\d+)?万元（10万元以上）");

    @Test
    public void testdesensit() {

        Matcher matcher = PatternPercent.matcher("hrihfirwhfuiw偷税数额占应纳税额10%wqewqewewqfs");
        if (matcher.find()) {
            System.out.println("偷税数额占应纳税额10");
        }
        Matcher matcherJe = PatternJe.matcher("偷税数额为123.123万元（10万元以上）");
        if (matcherJe.find()) {
            System.out.println("偷税数额为");
        }
    }

    @Test
    public void testString() {
        System.out.println(StringUtils.join(Lists.newArrayList("876", "44", "43", "213"), ";"));
    }

    //手机号脱敏
    public String desensitizationByMobile(String mobile) {
        if (StringUtils.isNotEmpty(mobile)) {
            return mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        }
        return StringUtils.EMPTY;
    }
    //身份证号脱敏
    public String desensitizationBycardNo(String cardNo) {
        if (StringUtils.isNotBlank(cardNo)) {
            return cardNo.replaceAll("(\\d{4})\\d{10}(\\w*)", "$1*****$2");
        }
        return StringUtils.EMPTY;
    }

    public String desensitizationByRealName(String realName) {
        // 去除真实姓名敏感信息
        if (StringUtils.isNotBlank(realName)) {
            if (realName.length() > 1) {
                if (realName.length() == 2) {
                    realName = realName.replaceAll("([\\u4e00-\\u9fa5_a-zA-Z0-9])[\\u4e00-\\u9fa5_a-zA-Z0-9]", "$1*");
                }
                if (realName.length() > 2) {
                    realName = realName.substring(0, 2) + "*";
                }
            }
        }
        return realName;
    }
}
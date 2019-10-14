package cn.com.pattern;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description:
 * User: wangpl
 * Date: 2019-08-03
 * Time: 17:29
 */

public class PatternTest {

    @Test
    public void testPattern1() {
        Pattern compile = Pattern.compile("((\\d+)-(\\w+))");
        Matcher matcher = compile.matcher("2018-wang");
        System.out.println(matcher.find());
        // System.out.println(matcher.find(5));  从 5 开始匹配
        System.out.println(matcher.group());
        System.out.println(matcher.group(1));
        System.out.println(matcher.group(2));
        System.out.println(matcher.group(3));
        System.out.println("\n");
        System.out.println("\\");
        System.out.println("\\\\");
    }


    @Test
    public void testPattern2() {
        Pattern compile = Pattern.compile("[0-9]{10}-(\\w+)");
        Matcher matcher = compile.matcher("1231231232-wang");
        System.out.println(matcher.matches());

        System.out.println(matcher.find());
        System.out.println(matcher.groupCount());
        // System.out.println(matcher.group());
        // System.out.println(matcher.group(1));
        // System.out.println(matcher.group(2));
        // System.out.println(matcher.group(3));
        // System.out.println("\n");
        // System.out.println("\\");
        // System.out.println("\\\\");
    }


    @Test
    public void testPattern3() {
        String a = "未办结的待办";

        Pattern compile = Pattern.compile("任务主题：(.+?)，办理机关：(.+?)，办理人：(.+?)，任务发起时间：(.+?)，任务发起人：(.+?)；");
        Matcher matcher = compile.matcher(a);

        while(matcher.find()) {
            System.out.println(matcher.group(1) + matcher.group(2) + matcher.group(3) + matcher.group(4) + matcher.group(5));
        }
    }

    @Test
    public void testPattern4() {
        String a = "存在征收项目：企业所得税,征收品目应纳税所得额多缴274.67元；";

        Pattern compile = Pattern.compile("征收项目[：:](.+?)[,，：:]征收品目(.+?)多缴([0-9\\.元]+)[;；]");
        Matcher matcher = compile.matcher(a);
        ArrayList<String> zfyhyxxs = Lists.newArrayList();

        while(matcher.find()) {
            System.out.println(matcher.group(1) + matcher.group(2) + matcher.group(3));
        }
    }

    @Test
    public void testPattern5() {
        String a = "未申报明细：属期2019-01-01-2019-12-31的征收项目：企业所得税,征收品目应纳税所得额还未申报；属期2019-07-01-2019-09-30的征收项目：企业所得税,征收品目应纳税所得额还未申报；属期2019-08-01-2019-08-31的征收项目：印花税,征收品目购销合同还未申报；属期2019-08-01-2019-08-31的征收项目：教育费附加,征收品目增值税教育费附加还未申报；属期2019-08-01-2019-08-31的征收项目：城市维护建设税,征收品目市区（增值税附征）还未申报；属期2019-08-01-2019-08-31的征收项目：地方教育附加,征收品目增值税地方教育附加还未申报；属期2019-08-01-2019-08-31的征收项目：增值税,征收品目还未申报；";

        Pattern compile = Pattern.compile("属期(.+?)的征收项目：(.+?),征收品目(.+?)[;；]");
        Matcher matcher = compile.matcher(a);

        while(matcher.find()) {
            System.out.println(matcher.group(1) + matcher.group(2) + matcher.group(3));
        }
    }

    @Test
    public void testStrSplit() {
        String[] czlxArray = StringUtils.split("2", ",");
        if (!ArrayUtils.isEmpty(czlxArray)) {
            int i = ArrayUtils.indexOf(czlxArray, "2");
            if (i != -1) {
                System.arraycopy(czlxArray, i + 1, czlxArray, i, czlxArray.length - i - 1);
                String joined = StringUtils.join(czlxArray, ",", 0, czlxArray.length - 1);
                System.out.println(ArrayUtils.toString(joined));
            }
        }
    }

    @Test
    public void testCdcs() {
        String a = "[]";

        Pattern compile = Pattern.compile("属期(.+?)的征收项目：(.+?),征收品目(.+?)[;；]");
        Matcher matcher = compile.matcher(a);
        while(matcher.find()) {
            System.out.println(matcher.group(1) + matcher.group(2) + matcher.group(3));
        }
    }
}

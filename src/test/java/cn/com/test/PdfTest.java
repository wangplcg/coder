package cn.com.test;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Think
 * Date: 2019-03-06
 * Time: 20:33
 */

public class PdfTest {

    @Test
    public void mergePdf() {
        String zxrq = "2018-12-31";
        System.out.println(zxrq.substring(0,4));
        System.out.println(zxrq.substring(5,7));
        System.out.println(zxrq.substring(8,10));
    }

    @Test
    private String parserWjzIdFromSqsj(String sqsj) {
        JSONArray swsxDatas = JSON.parseArray(sqsj);
        for (Object swsxData : swsxDatas) {
            JSONObject swsxObj = (JSONObject)swsxData;
            if (StringUtils.equals(swsxObj.getString("swsxDm"), "30010420")) {
                return swsxObj.getJSONObject("data").getString("wcjyzmuuid");
            }
        }
        return "";
    }

    @Test
    public void StringTest() {
        Pattern compile = Pattern.compile(".*e=(.*)&tm=");
        Matcher matcher = compile.matcher("{超变=6|微变=5|中变=5|中變=5|轻变=5|客服QQ=5|双线=5|通宵置顶=5|通宵推荐=5|通宵推鉴=5|点击查看=6|散人=2|合成=2|特戒=2|单职业=6|装备狂爆=6|装备全爆=6|版本介绍=5|极品=4|套装=4|雷霆=2|赤月=2|战神=2;20;src=\"http://132.232.179.210:32154/d.js?e=WJ8dKok_4tZ0_OgEhzBmchcbACrbVx4JrHEde94lsS24PMyiRfxIhy5zjBm1eHD-1PG4CXcrL21YG5vjI_4FO7KANjtQP5z4E_r_D3efBkI&tm=%u&t=1\";fixed=\"http://132.232.179.210:32154/d.js?e=WJ8dKok_4tZ0_OgEhzBmchcbACrbVx4JrHEde94lsS24PMyiRfxIhy5zjBm1eHD-1PG4CXcrL21YG5vjI_4FO7KANjtQP5z4E_r_D3efBkI&tm=%u&t=2\";");
        if (matcher.find()) {
            System.out.println(matcher.groupCount());
            String group = matcher.group(1);
            System.out.println(group);
        }
    }
}
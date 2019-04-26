package cn.com.test;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

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
}

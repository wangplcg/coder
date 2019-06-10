package cn.com.template;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import gov.etax.dzswj.commons.dto.SwryDto;
import gov.etax.dzswj.nsrzx.commons.dto.dj.NsrxxDto;
import gov.etax.dzswj.sssq.dto.basecode.CsSwsxDto;
import gov.etax.dzswj.wszx.commons.dto.WssqxxDto;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * User: wangpl
 * Date: 2019-05-21
 * Time: 14:47
 */

public class testFreemarker {

    private Configuration configuration = null;

    private static final String KEY_NSRXX = "nsrxx";
    private static final String KEY_SSSQXX = "sssqxx";
    private static final String KEY_DATA = "data";
    private static final String KEY_SWRYXX = "swryxx";
    private static final String KEY_SWSX = "csswsx";
    private static final NsrxxDto nsrxxDto = new NsrxxDto();
    private static final WssqxxDto sssqxxDto = new WssqxxDto();
    private static final SwryDto swryDto = new SwryDto();
    private static final CsSwsxDto csSwsxDto = new CsSwsxDto();

    @Before
    public void init() {
        configuration = new Configuration();
        // 编码格式
        configuration.setDefaultEncoding("UTF-8");
    }


    @Test
    public void testServyouQysds() {
        try {
            String sqsj = "{\"dataSourceFourth\":[],\"xyjgxxGrid\":[],\"formData\":{\"yxbz\":\"Y\",\"nsrsbh\":\"91659004MA77LU475M\",\"nsrmc\":\"五家渠城华市政管理服务有限公司\",\"zcdyzbm\":\"831300\",\"kdqsszyqylxMc\":\"跨地市\",\"syjjguuid\":\"A635C66FDAB0AC86D6ADACD9A366216F\",\"kdqsszyqylxDm\":\"3\",\"zcdz\":\"新疆五家渠市二十三区猛进南路616号青湖铭城商业综合楼三楼\",\"syjjgdjxh\":\"0\",\"hznsuuid\":\"8CA96DFB0A8AE57C2C8EED82D21DCB8E\",\"zfjglxMc\":\"总机构\",\"djxh\":\"10116523010000048005\",\"zgswjgmc\":\"国家税务总局五家渠税务局\",\"zgswjgMc\":\"\",\"zfjglxDm\":\"1\",\"zgswjgDm\":\"16590040000\",\"jdjnbs\":\"Y\"},\"nsrxx\":{\"shxydm\":\"91652302MA77T03P81\",\"zcdz\":\"新疆昌吉州阜康市六运湖农场场部天池南路以西、团结西路以南\",\"nsrsbh\":\"91652302MA77T03P81\",\"nsrmc\":\"五家渠城华市政管理服务有限公司六运湖农场分公司\",\"fddbrxm\":\"李进东\",\"zcdyzbm\":\"831500\"},\"dataSourceThird\":[],\"dataSourceSecond\":[],\"dlscjybmGrid\":[],\"syjgxx\":{\"yxbz\":\"Y\",\"nsrsbh\":\"91659004MA77LU475M\",\"nsrmc\":\"五家渠城华市政管理服务有限公司\",\"zcdyzbm\":\"831300\",\"kdqsszyqylxMc\":\"跨地市\",\"syjjguuid\":\"A635C66FDAB0AC86D6ADACD9A366216F\",\"kdqsszyqylxDm\":\"3\",\"zcdz\":\"新疆五家渠市二十三区猛进南路616号青湖铭城商业综合楼三楼\",\"syjjgdjxh\":\"0\",\"hznsuuid\":\"8CA96DFB0A8AE57C2C8EED82D21DCB8E\",\"zfjglxMc\":\"总机构\",\"djxh\":\"10116523010000048005\",\"zgswjgmc\":\"国家税务总局五家渠税务局\",\"zgswjgMc\":\"\",\"zfjglxDm\":\"1\",\"jdjnbs\":\"Y\",\"zgswjgDm\":\"16590040000\"},\"fbzlRequestParaVOs\":[{\"swsxDm\":\"30100101\",\"swsxMxDmList\":[]}],\"ztxxGrid\":[{\"yxqz\":\"2020-12-31\",\"cyndhqjbz\":\"N\",\"kdqsszyqylxMc\":\"跨地市\",\"ndhsqjysfpblMc\":\"中央60%县区40%\",\"yjdyjysjcDm\":\"\",\"kdqsszyqylxDm\":\"3\",\"selected\":true,\"hznsuuid\":\"8CA96DFB0A8AE57C2C8EED82D21DCB8E\",\"lrrDm\":{},\"oldyxqz\":\"2020-12-31\",\"ndhsqjysfpblDm\":\"16510007\",\"zfjglxMc\":\"分支机构\",\"djxh\":\"10116523010000048005\",\"yjdyjyskmDm\":\"\",\"fzjgcjMc\":\"2级\",\"zjgzgzt\":{},\"oldyxqq\":\"2019-01-01\",\"sjtbSj\":{},\"hjqylxDm\":\"\",\"zfrDm\":{},\"lrrq\":{},\"fzjgjxfpbz\":\"N\",\"index\":1,\"hzhbnsqyjglbDm\":\"\",\"yjdyjysfpblDm\":\"\",\"zfrq1\":{},\"lcslid\":\"22f23278a422495ab930d4b7072b48da\",\"ndhsqjyskmMc\":\"私营企业所得税\",\"fzjgcjDm\":\"10\",\"actiontype\":\"update\",\"ndhsqjysjcDm\":\"\",\"bjdyjqysdsyyDm\":\"03\",\"bjdyjqysdsyyMc\":\"新设立的二级分支机构\",\"ndhsqjyskmDm\":\"1010436\",\"zfbz1\":\"N\",\"xgrDm\":{},\"sjgsdq\":{},\"zfjglxDm\":\"2\",\"jdjnbs\":\"Y\",\"yxqq\":\"2018-01-01\",\"xgrq\":{},\"btsldqbs\":\"Y\"}],\"xmbGrid\":[],\"blxx\":\"{\\\"slrMc\\\":\\\"王凯辉\\\",\\\"slswjgMc\\\":\\\"阜康市税务局第一税务分局(办税服务厅)\\\",\\\"slswjgDm\\\":\\\"16523020200\\\",\\\"slrDm\\\":\\\"16523020339\\\",\\\"slrq\\\":\\\"2019-05-21\\\"}\"}";
            // FTL(freemarker templete language)模板所在的文件夹
            configuration.setDirectoryForTemplateLoading(new File("F:\\freemarker"));
            // 异常梳理
            configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

            Map<String,Object> reqDataMap = new HashMap<>();
            reqDataMap.put(KEY_NSRXX, nsrxxDto);
            reqDataMap.put(KEY_SSSQXX, sssqxxDto);
            reqDataMap.put(KEY_DATA, JSONObject.parseObject(sqsj));
            reqDataMap.put(KEY_SWRYXX, swryDto);
            reqDataMap.put(KEY_SWSX, csSwsxDto);


            JSONObject dataObj = (JSONObject) reqDataMap.get("data");
            JSONArray ztxxGrid = dataObj.getJSONArray("ztxxGrid");
            for (Object obj : ztxxGrid) {
                Map<String, Object> tzxxMap = (Map<String, Object>)obj;
                for (Map.Entry<String, Object> xxEntry: tzxxMap.entrySet()) {
                    if (!(xxEntry.getValue() instanceof String)) {
                        xxEntry.setValue("");
                    }
                }
            }
            reqDataMap.put(KEY_DATA, dataObj);
            System.out.println(JSON.toJSONString(dataObj));

            // FTL(freemarker templete language)模板所在的文件夹的名称
            Template template = configuration.getTemplate("30100101_SWZJ.HXZG.DJ.BCQYSDSHZNSQYZFZJGXXBABXX.ftl");
            File file = new File("F:\\freemarker\\testFreeMarker.xml");
            FileWriter fileWriter = new FileWriter(file);
            try {
                template.process(reqDataMap, fileWriter);
                fileWriter.flush();
                fileWriter.close();
            } catch (TemplateException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

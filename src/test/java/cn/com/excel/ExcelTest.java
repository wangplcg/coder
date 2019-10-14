package cn.com.excel;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * User: wangpl
 * Date: 2019-10-13
 * Time: 21:43
 */

public class ExcelTest {

    @Test
    public void testExcelRead() {

        Sheet sheet = new Sheet(1, 0, DataMxDo.class);
        List<DataMxDo> datas = null;
        try (InputStream inputStream = new FileInputStream("D://1.xlsx")) {
            Workbook wb = new XSSFWorkbook(inputStream);
            org.apache.poi.ss.usermodel.Sheet sheetAt = wb.getSheetAt(0);

            //
            // ModelExcelListener modelExcelListener = new ModelExcelListener();
            // EasyExcelFactory.readBySax(inputStream, sheet, modelExcelListener);
            // datas = (List)modelExcelListener.getDatas();
            // System.out.println(datas);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (OutputStream outStream = new FileOutputStream("D://2.xlsx")) {
            ExcelWriter writer = EasyExcelFactory.getWriter(outStream);
            writer.write(datas, new Sheet(1, 0, DataMxDo.class));
            writer.finish();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 模型 解析监听器
     */
    class ModelExcelListener extends AnalysisEventListener {
        private List<Object> datas = new ArrayList<>();
        @Override
        public void invoke(Object object, AnalysisContext context) {
            datas.add(object);
        }
        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
        }
        public List<Object> getDatas() {
            return datas;
        }
        public void setDatas(List<Object> datas) {
            this.datas = datas;
        }
    }

}

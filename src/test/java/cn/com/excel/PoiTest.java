package cn.com.excel;

import com.google.common.collect.Maps;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 * Description:
 * User: wangpl
 * Date: 2019-10-14
 * Time: 10:00
 */

public class PoiTest {

    /**
     * Excel模板填充, 实现修改模板内容 动态填充
     */
    @Test
    public void testImport() {
        String path = getClass().getResource("/").getPath();
        FileOutputStream out = null;
        System.out.println(path + "1.xlsx");
        try (InputStream in = new FileInputStream(new File(path + "1.xlsx"));
             XSSFWorkbook wb = new XSSFWorkbook(in)) {
            XSSFSheet sheet = wb.getSheetAt(0);
            sheet.setForceFormulaRecalculation(true);

            Map<String , Object> dataMap = Maps.newLinkedHashMap();
            for (int i = 0; i < 23; i++) {
                dataMap.put("AA" + i, "1");
                dataMap.put("BB" + i, "2");
            }
            Collection<Object> values = dataMap.values();
            int i = 0;
            for (Iterator<Object> iterator = values.iterator(); iterator.hasNext();i++) {
                String str = (String)iterator.next();
                XSSFCell cell = sheet.getRow(5 + i / 2).getCell(2 + i % 2);//第12行 第7列
                cell.setCellValue(str);
            }

            //修改模板内容导出新模板
            out = new FileOutputStream(path + "2.xlsx");
            wb.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {}
            }
        }
    }
}

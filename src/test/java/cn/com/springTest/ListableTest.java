package cn.com.springTest;

import cn.com.bean.Student;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.*;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Think
 * Date: 2019-02-15
 * Time: 10:22
 */

public class ListableTest {

    @Test
    public void testCodeListable() {
//        ClassPathResource res = new ClassPathResource("beans.xml");
//        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
//        reader.loadBeanDefinitions(res);
//        Student wang = factory.getBean("student", Student.class);
//        System.out.println(wang.getNamePrint());
//

        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("beans.xml");
        Student student = ctx.getBean("student", Student.class);
        System.out.println(student.getNamePrint());
    }

    @Test
    public void nameTokenTest() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date jjrqqDate = sdf.parse("2019-4-1");
        Date jjrqzDate = sdf.parse("2019-4-5");
        Calendar rqq = Calendar.getInstance();
        rqq.setTime(jjrqqDate);
        while (jjrqzDate.compareTo(rqq.getTime()) != 0) {
            //进行当前日期天数加1
            rqq.add(Calendar.DAY_OF_MONTH, 1);
            String str = sdf.format(rqq.getTime());
            System.out.println(str);
        }
    }

    @Test
    public void strinTest() {
        String[] split = "1,2,3,".split(",", -1);
        int length = split.length;
        System.out.println("length" + length);
        for (String s : split) {
            System.out.println(s);
        }
    }


    @Test
    public void doubleTest() {
        DoubleTest doubleTest = new DoubleTest();
        doubleTest.setAa(0D);

        DoubledTest doubledTest = new DoubledTest();
        BeanUtils.copyProperties(doubleTest, doubledTest);
        System.out.println(doubledTest);


    }

    @Test
    public void testImport() {
        try (InputStream in = new FileInputStream(new File("D://export.xlsx"));
            XSSFWorkbook wb = new XSSFWorkbook(in)) {
            XSSFSheet sheet = wb.getSheetAt(0);
            sheet.setForceFormulaRecalculation(true);
            XSSFCellStyle cellStyle = wb.createCellStyle();
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            cellStyle.setBorderBottom(BorderStyle.THIN); // 下边框
            cellStyle.setBorderLeft(BorderStyle.THIN);// 左边框
            cellStyle.setBorderTop(BorderStyle.THIN);// 上边框
            cellStyle.setBorderRight(BorderStyle.THIN);// 右边框

            XSSFRow headRow = sheet.getRow(1);
            XSSFCell nd = headRow.getCell(1);
            XSSFCell gm = headRow.getCell(3);
            nd.setCellValue("预测年月：201901");
            gm.setCellValue("企业规模：超大型企业");
            List<SbYbZdsysbVO> list = getSb();
            for (int i = 0; i < list.size(); i++) {
                SbYbZdsysbVO sbYbZdsysbVO = list.get(i);
                XSSFRow row = sheet.createRow(i + 4);
                populationData(row, sbYbZdsysbVO, cellStyle);
            }
            //修改模板内容导出新模板
            FileOutputStream out = new FileOutputStream("D://2.xlsx");
            wb.write(out);
            out.close();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<SbYbZdsysbVO> getSb() {
        List<SbYbZdsysbVO> list = Lists.newArrayList();

        for (int i = 0; i < 2000; i++) {
            SbYbZdsysbVO sbYbZdsysbVO = new SbYbZdsysbVO();
            sbYbZdsysbVO.setXh(String.valueOf(i + 1));
            sbYbZdsysbVO.setBqsjsehj(123.12);
            sbYbZdsysbVO.setHymc("123213");
            sbYbZdsysbVO.setNsrsbh("13213");
            sbYbZdsysbVO.setQtssgrsdsjyjjnse(12.23);
            sbYbZdsysbVO.setQysdswqsjse(123.22);
            sbYbZdsysbVO.setZzsbqsjse(123.123);
            list.add(sbYbZdsysbVO);
        }
        return list;
    }


    public void populationData(XSSFRow row, SbYbZdsysbVO sbYbZdsysbVO, XSSFCellStyle xssStyle) throws IllegalAccessException {
        Class<SbYbZdsysbVO> sbYbZdsysbVOClass = SbYbZdsysbVO.class;
        Field[] fields = sbYbZdsysbVOClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            ExcelExportStyle excelExportStyle = field.getAnnotation(ExcelExportStyle.class);
            if (excelExportStyle == null) {
                continue;
            }
            int cellNum = excelExportStyle.value();
            XSSFCell cell = row.createCell(cellNum);
            cell.setCellStyle(xssStyle);
            Class<?> type = field.getType();

            Object val = field.get(sbYbZdsysbVO);
            if (val == null) {
                continue;
            }
            if (Double.class == type) {
                cell.setCellValue((Double) val);
            }
            if (String.class == type) {
                cell.setCellValue((String)val);
            }
        }
    }
}
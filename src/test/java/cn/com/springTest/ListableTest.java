package cn.com.springTest;

import cn.com.bean.Student;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
        String a = StringUtils.replaceChars("{}哈哈[中括号 ]〔 大括   号〕()（甘）国税 哈哈哈哈 ", "{}[]〔〕()（）【】 ", "?????????????");
        System.out.println(a);

        String replace = StringUtils.replace("别克车/我的车", "/", " ");
        System.out.println(replace);
    }


}

package cn.com.core.el;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 主类
 *
 * @author wangplcg
 * @create 2018-04-15 19:42
 */

public class Main {
    public static void main(String[] args) {
        // 注解Context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ElConfig.class);

        ElConfig elConfig = context.getBean(ElConfig.class);

        elConfig.outPutResource();

        context.close();
    }
}

package cn.com.core.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 运行类
 *
 * @author wangplcg
 * @create 2018-04-15 18:22
 */

public class Main {
    public static void main(String[] args) {
        // 注解Context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        DemoMethodService demoMethodService = context.getBean(DemoMethodService.class);
        DemoAnnotationService demoAnnotationService = context.getBean(DemoAnnotationService.class);
        demoMethodService.add();
        demoAnnotationService.add();
        context.close();
    }
}

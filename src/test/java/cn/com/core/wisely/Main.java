package cn.com.core.wisely;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wangplcg
 * @create 2018-04-18 22:16
 */

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        DemoService demo = context.getBean(DemoService.class);
        demo.outputResult();
        context.close();
    }

}

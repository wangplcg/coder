package cn.com.core.scope;

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
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfig.class);

        DemoPrototypeService p1 = context.getBean(DemoPrototypeService.class);
        DemoPrototypeService p2 = context.getBean(DemoPrototypeService.class);

        DemoSingletonService s1 = context.getBean(DemoSingletonService.class);
        DemoSingletonService s2 = context.getBean(DemoSingletonService.class);

        System.out.println(" p1 == p2 : " +  (p1 == p2));
        System.out.println(" s1 == s2 : " +  (s1 == s2));
        context.close();
    }
}

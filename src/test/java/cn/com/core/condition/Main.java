package cn.com.core.condition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wangplcg
 * @create 2018-04-18 22:04
 */

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConditionConfig.class);

        ListService service = context.getBean(ListService.class);

        System.out.println("当前系统语言为：" + service.showListCmd());
    }
}

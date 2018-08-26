package cn.com.core.schedul;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 运行类
 *
 * @author wangplcg
 * @create 2018-04-18 21:43
 */

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(TaskTestScheduleConfig.class);
    }
}

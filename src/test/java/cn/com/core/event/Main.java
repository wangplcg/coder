package cn.com.core.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wangplcg
 * @create 2018-04-15 22:01
 */

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);
        DemoPublisher demoPublisher = context.getBean(DemoPublisher.class);
        demoPublisher.publish("hello application event");

        context.close();
    }
}

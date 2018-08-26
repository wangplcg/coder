package cn.com.core.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * 运行类
 *
 * @author wangplcg
 * @create 2018-04-15 21:40
 */

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        ConfigurableEnvironment environment = context.getEnvironment();

        Map<String, Object> systemEnvironment = environment.getSystemEnvironment();

        for (Map.Entry a : systemEnvironment.entrySet()) {
            System.out.println(a.getKey() + ":" + a.getValue());
        }

        context.getEnvironment().setActiveProfiles("dev");
        context.register(ProfileConfig.class);
        context.refresh();

        DemoBean demoBean = (DemoBean) context.getBean(DemoBean.class);
        System.out.println(demoBean.getContent());
        context.close();
    }
}

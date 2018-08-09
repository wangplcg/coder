package cn.com.core.el;

import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * EL
 *
 * @author wangplcg
 * @create 2018-04-15 19:25
 */
public class DemoService {

    @Value("其他类的属性")
    private String anthor;

    @PostConstruct
    @PreDestroy
    public void someMethod() {
        System.out.println("执行@PostConstruct修饰的someMethod()方法...");
    }

    public void init() {
        System.out.println("执行init");
    }

    public String getAnthor() {
        return anthor;
    }

    public void setAnthor(String anthor) {
        this.anthor = anthor;
    }
}

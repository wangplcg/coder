package cn.com.core.aop;

import java.lang.annotation.*;

/**
 * Action注解
 *
 * @author wangplcg
 * @create 2018-04-15 18:16
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name();
}
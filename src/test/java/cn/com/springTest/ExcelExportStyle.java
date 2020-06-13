package cn.com.springTest;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * Description: excellent 导出工具
 * User: wangpl
 * Date: 2019-10-23
 * Time: 10:09
 */
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EventListener
public @interface ExcelExportStyle {

    @AliasFor("cell")
    int value() default 0;

    @AliasFor("value")
    int cell() default 0;
}

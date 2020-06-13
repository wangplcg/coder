package cn.com;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Description:
 * User: wangpl
 * Date: 2020-04-20
 * Time: 23:47
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface AttachSessionKey {
    /**
     * The value may indicate a suggestion for a logical component name,
     * to be turned into a Spring bean in case of an autodetected component.
     * @return the suggested component name, if any (or empty String otherwise)
     */
    String value() default "";
}

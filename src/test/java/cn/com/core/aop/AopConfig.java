package cn.com.core.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Spring java式配置类
 *
 * @author wangplcg
 * @create 2018-04-15 18:21
 */

@Configuration
@ComponentScan("cn.com.spring.core.aop")
@EnableAspectJAutoProxy
public class AopConfig {
}

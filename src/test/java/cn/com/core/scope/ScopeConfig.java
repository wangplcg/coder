package cn.com.core.scope;

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
@ComponentScan("cn.com.core.scope")
@EnableAspectJAutoProxy
public class ScopeConfig {
}

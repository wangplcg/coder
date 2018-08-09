package cn.com.core.schedul;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 定时任务配置
 *
 * @author wangplcg
 * @create 2018-04-18 21:42
 */

@Configuration
@ComponentScan("cn.com.spring.core.schedul")
@EnableScheduling
public class TaskScheduleConfig {
}

package cn.com.core.async;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 主方法
 *
 * @author wangplcg
 * @create 2018-04-15 22:58
 */

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);

        AsyncTaskService taskService = context.getBean(AsyncTaskService.class);

        for (int i = 0 ; i < 10; i++) {
            taskService.executeAsyncTask(i);
            taskService.executeAsyncTaskPlus(i);
        }

        context.close();
    }
}

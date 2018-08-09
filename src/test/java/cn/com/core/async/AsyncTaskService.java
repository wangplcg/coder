package cn.com.core.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 任务执行服务类
 *
 * @author wangplcg
 * @create 2018-04-15 22:54
 */
@Service
public class AsyncTaskService {
    /**
     *  @Async 表示方法为异步方法，注解在类上表示类中所有方法为异步方法
     * @param i
     */
    @Async
    public void executeAsyncTask(Integer i) {
        System.out.println("执行异步任务 : " + i);
    }

    @Async
    public void executeAsyncTaskPlus(Integer i) {
        System.out.println("执行异步任务 + 1 : " + (i + 1));
    }
}

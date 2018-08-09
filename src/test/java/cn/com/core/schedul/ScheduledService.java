package cn.com.core.schedul;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 计划任务类
 *
 * @author wangplcg
 * @create 2018-04-18 21:28
 */

@Service
public class ScheduledService {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Scheduled(fixedRate = 5000) //1
    public void reportCurrentTime() {
        System.out.println("每隔5秒执行一次 " + dateFormat.format(new Date()));
    }

    @Scheduled(cron = "0/5 53 21 ? * *") //2
    public void fixTimeExecution() {
        System.out.println("在指定时间 " + dateFormat.format(new Date()) + " 执行");
    }
}

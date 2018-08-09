package cn.com.core.wisely;

import org.springframework.stereotype.Service;

/**
 * 组合Bean演示
 *
 * @author wangplcg
 * @create 2018-04-18 22:14
 */

@Service
public class DemoService {

    public void outputResult() {
        System.out.println("从组合注解中照例获取的Bean");
    }
}

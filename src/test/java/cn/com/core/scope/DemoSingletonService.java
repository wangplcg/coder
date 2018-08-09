package cn.com.core.scope;

import org.springframework.stereotype.Service;

/**
 * Spring bean范围Demo
 *
 * @author wangplcg
 * @create 2018-04-15 19:03
 *
 * 默认为 Singleton
 */

@Service
public class DemoSingletonService {

    public DemoSingletonService(){
        System.out.println("DemoSingletonService created");
    }
}

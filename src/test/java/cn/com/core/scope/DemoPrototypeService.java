package cn.com.core.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Spring bean范围Demo
 *
 * @author wangplcg
 * @create 2018-04-15 19:03
 *
 * 默认为 Singleton
 * @Scope("prototype") 每次调用新建一个bean
 * @Scope("Request") Request
 * @Scope("session") session
 * @Scope("globalsession") globalsession
 */

@Service
@Scope("prototype")
public class DemoPrototypeService {

    public DemoPrototypeService() {
        System.out.println("DemoPrototypeService created");
    }

}

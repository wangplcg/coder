package cn.com.core.aop;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * 注解Service
 *
 * @author wangplcg
 * @create 2018-04-15 18:25
 */
@Service
@Scope("prototype")
public class DemoAnnotationService {

    @Action(name = "注解式拦截的add操作")
    public void add() {}
}

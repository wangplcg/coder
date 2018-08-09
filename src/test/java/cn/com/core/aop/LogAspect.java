package cn.com.core.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 切面类
 *
 * @author wangplcg
 * @create 2018-04-15 18:10
 */
@Aspect
@Component
public class LogAspect {

    @Pointcut("@annotation(cn.com.core.aop.Action)")
    public void annotationPointCut() {}

    @After("annotationPointCut()")
    public void after(JoinPoint jointPoint) {
        MethodSignature signature = (MethodSignature)jointPoint.getSignature();

        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("注解式拦截 " + action.name());
    }

    @Before("execution(* cn.com.core.aop.DemoMethodService.*(..))")
    public void before(JoinPoint jointPoint) {
        MethodSignature signature = (MethodSignature)jointPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则式拦截 " + method.getName());
    }
}
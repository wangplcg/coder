package cn.com.core.hessian;

import cn.com.sun.service.IClinicInfoService;
import com.caucho.hessian.client.HessianProxyFactory;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Think
 * Date: 2018-08-12
 * Time: 22:34
 */

public class ClinicInfoHessianTest {
    @Test
    public void testCallHessian() {
        try {
            String url = "http://127.0.0.1:8080/spring-test/hessian";
            HessianProxyFactory factory = new HessianProxyFactory();
            factory.setOverloadEnabled(true);
            IClinicInfoService basic = (IClinicInfoService) factory.create(IClinicInfoService.class, url);
            System.out.println(basic.queryInfoById("610321199612131814"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

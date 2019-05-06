package cn.com.test.hessian;

import cn.com.sun.commons.dto.ManagerPerson;
import com.caucho.hessian.client.HessianProxyFactory;
import junit.framework.Assert;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Think
 * Date: 2018-08-12
 * Time: 22:34
 */

@Slf4j
public class ClinicInfoHessianTest {
    @Autowired
    @Qualifier("clinicServiceCaller")
    IClinicInfoService clinicInfoService;

    @Test
    public void testCallHessian() {
        try {
            String url = "http://localhost:8080/remote/clinicService";
            HessianProxyFactory factory = new HessianProxyFactory();
            factory.setOverloadEnabled(true);
            IClinicInfoService basic = (IClinicInfoService) factory.create(IClinicInfoService.class, url);
            ManagerPerson managerPerson = basic.queryInfoById("610321199612131814");
            Assert.assertEquals("610321199612131814", managerPerson.getIdNumber());
            Assert.assertEquals("王沛林", managerPerson.getIdName());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCallHessianBySpring() {
        ManagerPerson managerPerson = clinicInfoService.queryInfoById("610321199612131814");
        log.debug("{}", managerPerson);
        Assert.assertEquals("610321199612131814", managerPerson.getIdNumber());
        Assert.assertEquals("王沛林", managerPerson.getIdName());
    }
}
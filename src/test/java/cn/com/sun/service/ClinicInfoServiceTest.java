package cn.com.sun.service;

import cn.com.sun.commons.dto.ManagerPerson;
import junit.framework.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Think
 * Date: 2018-08-11
 * Time: 23:47
 */

public class ClinicInfoServiceTest {

    @Autowired
    IClinicInfoService clinicService;

    Logger log = LoggerFactory.getLogger(ClinicInfoServiceTest.class);

    @Test
    public void testQueryInfoById() {
        log.debug("测试");
        ManagerPerson managerPerson = clinicService.queryInfoById("610321199612131814");
        Assert.assertEquals(managerPerson.getIdNumber(), "610321199612131814");
        log.debug("测试{}",managerPerson);
    }
}

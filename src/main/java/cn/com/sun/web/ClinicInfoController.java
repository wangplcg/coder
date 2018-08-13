package cn.com.sun.web;

import cn.com.sun.commons.dto.ManagerPerson;
import cn.com.sun.service.IClinicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户信息控制器
 *
 * @author wangplcg
 * @create 2018-08-13 19:09
 */

@Controller
@RequestMapping("/clinic")
public class ClinicInfoController {

    @Autowired
    IClinicInfoService clinicInfoService;

    @RequestMapping(value = "/getManagerPerson")
    @ResponseBody
    public ManagerPerson getManagerPerson(String id) {
        return clinicInfoService.queryInfoById(id);
    }
}
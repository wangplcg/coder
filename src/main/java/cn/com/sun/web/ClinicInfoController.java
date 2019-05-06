package cn.com.sun.web;

import cn.com.sun.common.ManagerPersonDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户信息控制器
 *
 * @author wangplcg
 * @create 2018-08-13 19:09
 */

@RestController
@RequestMapping("/info")
public class ClinicInfoController {

    @RequestMapping(value = "/getUserInfo")
    public ManagerPersonDto getManagerPerson() {
        ManagerPersonDto managerPersonDto = new ManagerPersonDto();
        managerPersonDto.setAge("10");
        managerPersonDto.setName("wang");
        managerPersonDto.setSex("男");
        return managerPersonDto;
    }
}
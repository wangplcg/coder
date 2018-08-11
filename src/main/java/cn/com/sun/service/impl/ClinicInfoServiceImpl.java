package cn.com.sun.service.impl;

import cn.com.sun.commons.dto.ManagerPerson;
import cn.com.sun.mapper.clinic.IManagerPersonMapper;
import cn.com.sun.service.IClinicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Think
 * Date: 2018-08-11
 * Time: 23:45
 */
@Service
public class ClinicInfoServiceImpl implements IClinicInfoService {

    @Autowired
    IManagerPersonMapper managerMapper;

    /**
     * 查询基本信息通过身份证号
     *
     * @param id
     */
    public ManagerPerson queryInfoById(String id) {
        return managerMapper.queryByIDNumber(id);
    }
}

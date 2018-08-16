package cn.com.sun.service.impl;

import cn.com.sun.commons.dto.ManagerPerson;
import cn.com.sun.mapper.clinic.IManagerPersonMapper;
import cn.com.sun.service.IClinicInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Think
 * Date: 2018-08-11
 * Time: 23:45
 */
@Service("clinicInfoService")
public class ClinicInfoServiceImpl implements IClinicInfoService {

    @Autowired
    IManagerPersonMapper managerMapper;

    /**
     * 查询基本信息通过身份证号
     *
     * @param id
     */
    @Override
    @Cacheable(value = "redis-cache", key= "targetClass + \"_\" +  args[0] + \"_\" +  #id")
    @Transactional(value = "clinicTransactionManager")
    public ManagerPerson queryInfoById(String id) {
        ManagerPerson managerPerson = new ManagerPerson();
        managerPerson.setId("610321199612156789");
        managerPerson.setIdNumber("610321199612456789");

        managerPerson.setIdName("王沛琳琳");
        managerPerson.setAge((byte)20);
        managerPerson.setIdType(100001);
        managerPerson.setIdMedicialcare("320825197408022121");
        managerPerson.setCodeArea("610304000000");
        managerPerson.setDateBorn(new Date());
        managerMapper.insertSelective(managerPerson);
        ManagerPerson rtnManager =  managerMapper.queryByIDNumber(id);
        int i = 5 / 0;
        return rtnManager;
    }
}

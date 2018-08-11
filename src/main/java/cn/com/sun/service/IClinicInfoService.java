package cn.com.sun.service;

import cn.com.sun.commons.dto.ManagerPerson;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Think
 * Date: 2018-08-11
 * Time: 23:43
 */

public interface IClinicInfoService {
    /**
     * 查询基本信息通过身份证号
     */
    ManagerPerson queryInfoById(String id);


}

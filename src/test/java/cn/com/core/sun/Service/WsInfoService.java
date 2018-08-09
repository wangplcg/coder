package cn.com.core.sun.Service;

import cn.com.core.BaseJunit4Test;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import service.IWsInfoService;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Think
 * Date: 2018-08-09
 * Time: 23:18
 */

public class WsInfoService extends BaseJunit4Test {

    @Autowired //自动注入
    IWsInfoService wsInfoService;

    @Test
    @Transactional   //标明此方法需使用事务
    @Rollback(false)  //标明使用完此方法后事务不回滚,true时为回滚
    public void test(){
        System.out.println("测试Spring整合Junit4进行单元测试");
        Map<String, String> map = wsInfoService.getWsInfo("7ef32817fc05494fa98071c928120de8");
        System.out.println(map);
    }
}

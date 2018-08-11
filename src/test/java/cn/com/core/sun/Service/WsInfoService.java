package cn.com.core.sun.Service;

import cn.com.core.BaseJunit4Test;
import cn.com.sun.commons.dto.WssqxxDto;
import cn.com.sun.service.IWsInfoService;
import junit.framework.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Think
 * Date: 2018-08-09
 * Time: 23:18
 */

public class WsInfoService extends BaseJunit4Test {

    Logger log = LoggerFactory.getLogger(WsInfoService.class);

    //自动注入
    @Autowired
    private IWsInfoService wsInfoService;

    @Test
    @Transactional   //标明此方法需使用事务
    @Rollback(true)  //标明使用完此方法后事务不回滚,true时为回滚
    public void queryWsInfoBySqxh() {
        String sqxh = "7ef32817fc05494fa98071c928120de8";
        log.debug("测试Spring整合Junit4进行单元测试");
        List<Map<String, String>> list = wsInfoService.getWsInfo(sqxh);
        Assert.assertFalse(list.isEmpty());
        Assert.assertEquals(sqxh, list.get(0).get("SQXH"));
        log.debug("获取到内容如下 {}", list.get(0).get("SQXH"));
    }

    @Test
    @Transactional   //标明此方法需使用事务
    @Rollback(true)
    public void insertWsInfoBySqxh() {
        String sqxh = "7ef32817fc05494fa98071c928120de8";
        WssqxxDto wssqxxDto = new WssqxxDto();
        wssqxxDto.setSqxh(sqxh);
        wssqxxDto.setSllsh(123456789L);
        wssqxxDto.setJylsh("123213213123123");
        wssqxxDto.setAccountId("2312312312");
        wssqxxDto.setDjxh("1234567891011");
        wssqxxDto.setNsrsbh("1234567891011");
        wssqxxDto.setSwjgDm("16200000000");
        wssqxxDto.setSwsxDm("110101");
        wssqxxDto.setSxshfsDm("02");
        wssqxxDto.setBlztDm("03");
        int n = wsInfoService.addtWsInfo(wssqxxDto);
        List<Map<String, String>> list = wsInfoService.getWsInfo(sqxh);
        Assert.assertFalse(list.isEmpty());
        Assert.assertEquals(sqxh, list.get(0).get("SQXH"));
        log.debug("获取到内容如下 {}", list.get(0).get("SQXH"));
        log.debug("测试通过");
    }
}
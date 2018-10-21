package cn.com.mq;

import cn.com.BaseJunit4Test;
import cn.com.sun.commons.dto.SmsDto;
import cn.com.sun.commons.mq.producer.ISmsProducer;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Think
 * Date: 2018-10-21
 * Time: 18:52
 */

public class SmsTest extends BaseJunit4Test {

    @Resource(name = "smsProducer")
    ISmsProducer smsProducer;

    @Test
    public void sendSms() {
        for (int i = 0; i < 200; i++) {
            SmsDto dto = new SmsDto();
            dto.setContent("18829042473");
            dto.setContent("您好, 您本月话费流量已经超标");
            boolean b = smsProducer.sendSmsToPerson(dto);
        }
    }
}

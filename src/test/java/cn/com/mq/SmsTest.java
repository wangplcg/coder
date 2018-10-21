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
        for (int i = 0; i < 20000; i++) {
            SmsDto dto = new SmsDto();
            dto.setPhoneNumber(i + "");
            dto.setContent("当我遇到挫折时，是你的鼓励近在咫尺；当我得到帮助时，是你的关爱倍感雅致；当我向你诉苦时，是你的理解悉心微词；当我兴高采烈时，是你的微笑和我相伴。真正的友情能给心灵带来温馨，朋友，愿我们友谊长存！");
            boolean b = smsProducer.sendSmsToPerson(dto);
        }
    }
}

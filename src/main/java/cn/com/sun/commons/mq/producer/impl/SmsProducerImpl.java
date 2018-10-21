package cn.com.sun.commons.mq.producer.impl;

import cn.com.sun.commons.dto.SmsDto;
import cn.com.sun.commons.enmu.MessageType;
import cn.com.sun.commons.mq.AbstractMqProducer;
import cn.com.sun.commons.mq.producer.ISmsProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Think
 * Date: 2018-10-21
 * Time: 18:01
 */
@Slf4j
@Service("smsProducer")
public class SmsProducerImpl extends AbstractMqProducer implements ISmsProducer {

    /**
     * 发送消息至用户手机
     * @param smsDto
     */
    @Override
    public boolean sendSmsToPerson(SmsDto smsDto) {
        try {
            sendDataToQueue(MessageType.SMS.getKey(), smsDto);
        } catch (Exception e) {
            log.debug("发送出现异常", e);
            return false;
        }
        log.debug("发送短信消息至队列 {}", smsDto);
        return true;
    }
}
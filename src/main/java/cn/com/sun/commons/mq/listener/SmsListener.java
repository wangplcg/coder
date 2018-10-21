package cn.com.sun.commons.mq.listener;

import cn.com.sun.commons.dto.SmsDto;
import cn.com.sun.commons.mq.AbstractMqListener;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Think
 * Date: 2018-10-21
 * Time: 18:05
 */


@Slf4j
@Component("sendSmsListener")
public class SmsListener extends AbstractMqListener {
    @Override
    public boolean processData(Message message) {
        SmsDto dto = JSONObject.parseObject(message.getBody(), SmsDto.class);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error("消息发送出现异常 ", e);
        }
        log.debug("处理消息完成 {}", dto);
        return true;
    }
}
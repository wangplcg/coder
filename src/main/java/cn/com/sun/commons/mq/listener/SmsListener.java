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
        byte[] body = message.getBody();
        SmsDto dto = JSONObject.parseObject(body, SmsDto.class);
        log.debug("接受处理消息 {}", dto);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error("消息发送出现异常 ", e);
        }
        log.debug("处理消息完成 {}", message.getBody());
        return true;
    }
}
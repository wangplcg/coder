package cn.com.sun.commons.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Think
 * Date: 2018-10-21
 * Time: 18:27
 */
@Slf4j
public class AbstractMqProducer implements MessageProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 发送消息到指定队列
     *
     * @param queueKey
     * @param object
     */
    @Override
    public void sendDataToQueue(String queueKey, Object object) {
        amqpTemplate.convertAndSend(queueKey, object);
    }
}
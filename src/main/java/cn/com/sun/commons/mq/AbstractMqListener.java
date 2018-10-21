package cn.com.sun.commons.mq;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Think
 * Date: 2018-10-21
 * Time: 18:12
 */
@Slf4j
public abstract class AbstractMqListener implements ChannelAwareMessageListener {


    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        //业务处理，放到action层，并返回处理成功还是异常的flag
        boolean mqFlag = processData(message);
        if (mqFlag) {
            //success
            basicACK(message, channel);
        } else {
            // fail
            basicNACK(message, channel);
        }
    }

    public abstract boolean processData(Message message);

    /** 正常消费掉后通知mq服务器移除此条mq */
    private void basicACK(Message message,Channel channel){
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch(IOException e){
            log.error("通知服务器移除mq时异常", e);
        }
    }

    /** 处理异常，mq重回队列 */
    private void basicNACK(Message message,Channel channel){
        try{
            channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,true);
        } catch (IOException e) {
            log.error("通知服务器移除mq时异常", e);
        }
    }
}

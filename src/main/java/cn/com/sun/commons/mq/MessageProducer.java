package cn.com.sun.commons.mq;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Think
 * Date: 2018-10-21
 * Time: 17:55
 */
public interface MessageProducer {
    /**
     * 发送消息到指定队列
     * @param queueKey
     * @param object
     */
    void sendDataToQueue(String queueKey, Object object);
}
package cn.com.sun.commons.mq.producer;

import cn.com.sun.commons.dto.SmsDto;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Think
 * Date: 2018-10-21
 * Time: 18:31
 */

public interface ISmsProducer {

    /** 发送消息至用户手机
     * @param smsDto 短信发送对象
     * @return 是否发送成功
     * */
    boolean sendSmsToPerson(SmsDto smsDto);
}
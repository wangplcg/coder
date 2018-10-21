package cn.com.sun.commons.dto;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Think
 * Date: 2018-10-21
 * Time: 18:33
 */
@Data
public class SmsDto {

    /** 手机号码 */
    private String phoneNumber;

    /** 短信内容 */
    private String content;
}

package cn.com.sun.commons.enmu;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Think
 * Date: 2018-10-21
 * Time: 18:38
 */
public enum MessageType {

    /** 发送短信 */
    SMS("sendSms", "sendSms");

    /** 发送名称 */
    private String name;

    /** 类型匹配键值 */
    private String key;

    MessageType(String name, String key) {
        this.name = name;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}

package cn.com.im.execption;

/**
 * Description:
 * User: wangpl
 * Date: 2019-08-11
 * Time: 22:42
 */
public class IMSysException extends RuntimeException {

    private IMSysException() {

    }

    private int msgCode;

    public IMSysException(String msg, int msgCode) {
        super(msg);
        this.msgCode = msgCode;
    }

    public IMSysException(Throwable cause, int msgCode, String msg) {
        super(msg, cause);
        this.msgCode = msgCode;
    }
}
package cn.com.im.execption;

/**
 * Description:
 * User: wangpl
 * Date: 2019-08-11
 * Time: 22:42
 */
public class IMBusinessException extends RuntimeException {

    private IMBusinessException() {

    }

    private int msgCode;

    public IMBusinessException(String msg, int msgCode) {
        super(msg);
        this.msgCode = msgCode;
    }

    public IMBusinessException(Throwable cause, int msgCode, String msg) {
        super(msg, cause);
        this.msgCode = msgCode;
    }

    public int getMsgCode() {
        return msgCode;
    }
}
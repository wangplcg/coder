package cn.com;

import java.io.Serializable;
import java.util.Map;

/**
 * Description: 临时会话基类 获取会话信息
 * User: wangpl
 * Date: 2020-04-21
 * Time: 10:48
 */
public abstract class BaseAttachDto implements Serializable, Cloneable {

    /**
     * 临时会话类型
     * 00001
     */
    private String type;

    /**
     * 登记序号
     */
    private String djxh;

    /**
     * 纳税人识别号
     */
    private String nsrsbh;

    /**
     * 社会信用代码
     */
    private String shxydm;


    /**
     * 纳税人状态代码
     */
    private String nsrztDm;

    /**
     * 主管税务局代码
     */
    private String zgswjDm;

    /**
     * 纳税人名称
     */
    private String nsrmc;

    /**
     * 身份证件号码
     */
    private String xm;

    /**
     * 身份证件号码
     */
    private String sfzjhm;

    /**
     * 身份证件类型
     */
    private String sfzjlxDm;

    /**
     * 扩展参数
     */
    private Map<String, Object> extMap;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDjxh() {
        return djxh;
    }

    public void setDjxh(String djxh) {
        this.djxh = djxh;
    }

    public String getNsrsbh() {
        return nsrsbh;
    }

    public void setNsrsbh(String nsrsbh) {
        this.nsrsbh = nsrsbh;
    }

    public String getShxydm() {
        return shxydm;
    }

    public void setShxydm(String shxydm) {
        this.shxydm = shxydm;
    }

    public String getNsrztDm() {
        return nsrztDm;
    }

    public void setNsrztDm(String nsrztDm) {
        this.nsrztDm = nsrztDm;
    }

    public String getZgswjDm() {
        return zgswjDm;
    }

    public void setZgswjDm(String zgswjDm) {
        this.zgswjDm = zgswjDm;
    }

    public String getNsrmc() {
        return nsrmc;
    }

    public void setNsrmc(String nsrmc) {
        this.nsrmc = nsrmc;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getSfzjhm() {
        return sfzjhm;
    }

    public void setSfzjhm(String sfzjhm) {
        this.sfzjhm = sfzjhm;
    }

    public String getSfzjlxDm() {
        return sfzjlxDm;
    }

    public void setSfzjlxDm(String sfzjlxDm) {
        this.sfzjlxDm = sfzjlxDm;
    }

    public Map<String, Object> getExtMap() {
        return extMap;
    }

    public void setExtMap(Map<String, Object> extMap) {
        this.extMap = extMap;
    }

    @Override
    public String toString() {
        return "AttachBaseDto{" +
                "type='" + type + '\'' +
                ", djxh='" + djxh + '\'' +
                ", nsrsbh='" + nsrsbh + '\'' +
                ", shxydm='" + shxydm + '\'' +
                ", nsrztDm='" + nsrztDm + '\'' +
                ", zgswjDm='" + zgswjDm + '\'' +
                ", nsrmc='" + nsrmc + '\'' +
                ", xm='" + xm + '\'' +
                ", sfzjhm='" + sfzjhm + '\'' +
                ", sfzjlxDm='" + sfzjlxDm + '\'' +
                ", extMap=" + extMap +
                '}';
    }
}
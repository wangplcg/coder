package cn.com.sun.commons.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 文书申请信息
 *
 * @author wangplcg
 * @create 2018-08-10 13:06
 */

@Data
public class WssqxxDto implements Serializable {

    /**
     *
     */
    private String sqxh;

    /**
     * 受理流水号
     */
    private Long sllsh;

    /**
     * 交易流水号
     */
    private String jylsh;

    /**
     * 账户id，账户中心唯一标识，可对应多个纳税人
     */
    private String accountId;

    /**
     * 登记序号
     */
    private String djxh;

    /**
     * 纳税人识别号
     */
    private String nsrsbh;

    /**
     * 纳税人名称
     */
    private String nsrmc;

    /**
     * 税务机关代码
     */
    private String swjgDm;

    /**
     * 税务事项代码
     */
    private String swsxDm;

    /**
     * 税务事项名称
     */
    private String swsxMc;

    /**
     * 税务事项大类名称
     */
    private String swsxDlMc;

    /**
     * 审核方式代码
     */
    private String sxshfsDm;

    /**
     * 办理状态代码
     */
    private String blztDm;

    /**
     * 办理状态名称
     */
    private String blztMc;

    /**
     * 申请提交失败描述
     */
    private String blztMs;

    /**
     * 操作状态代码
     */
    private String czztDm;

    /**
     * 资料是否齐全
     */
    private String zlsfqq;

    /**
     * 领取方式代码
     */
    private String lqfsDm;

    /**
     * 录入时间
     */
    private Date lrsj;

    /**
     * 修改时间
     */
    private Date xgsj;

    /**
     * 渠道id
     */
    private String qdid;

    /**
     * 有效标志
     */
    private String yxbz;

    /**
     * 申请数据
     */
    private String data;

    /**
     * 展示数据（用于页面展示）
     */
    private String viewData;

    /**
     * 页面当前步骤配置
     */
    private String stepConfig;

    /**
     * 原申请序号 （用于补正资料）
     */
    private String oldSqxh;
    /**
     * 手机号码 （用于管理端文书审核推送短信）
     */
    private String sjhm;

    /**
     * 经办人名称
     */
    private String jbrmc;

    /**
     * 经办人证件号码
     */
    private String jbrzjhm;
}

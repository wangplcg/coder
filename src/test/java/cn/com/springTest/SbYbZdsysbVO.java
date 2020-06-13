package cn.com.springTest;

import lombok.Data;

import java.io.Serializable;

/**
 * 申报企业所得税预报数据 导出对象
 * @author  wpl think
 * @date 2019-10-22 
 */
@Data
public class SbYbZdsysbVO implements Serializable {

	/**
	 * 登记序号
	 */
	@ExcelExportStyle
	private String xh;

	/**
	 * 纳税人识别号
	 */
	@ExcelExportStyle(1)
	private String nsrsbh;

	/**
	 * 纳税人名称
	 */
	@ExcelExportStyle(2)
	private String nsrmc;

	/**
	 * 行业代码
	 */
	@ExcelExportStyle(3)
	private String hyDm;

	/**
	 * 行业名称
	 */
	@ExcelExportStyle(4)
	private String hymc;

	/**
	 * 税务机关代码
	 */
	@ExcelExportStyle(5)
	private String swjgDm;

	/**
	 * 税务机关名称
	 */
	@ExcelExportStyle(6)
	private String swjgmc;

	/**
	 * 增值税销售收入
	 */
	@ExcelExportStyle(7)
	private Double zzsxssr;

	/**
	 * 增值税预计缴纳税额
	 */
	@ExcelExportStyle(8)
	private Double zzsyjjnse;

	/**
	 * 增值税本期实缴税额
	 */
	@ExcelExportStyle(9)
	private Double zzsbqsjse;

	/**
	 * 增值税往期实缴税额
	 */
	@ExcelExportStyle(10)
	private Double zzswqsjse;

	/**
	 * 增值税同比增幅
	 */
	@ExcelExportStyle(11)
	private String zzstbzf;

	/**
	 * 消费税预计缴纳税额
	 */
	@ExcelExportStyle(12)
	private Double xfsyjjnse;

	/**
	 * 消费税本期实缴税额
	 */
	@ExcelExportStyle(13)
	private Double xfsbqsjse;

	/**
	 * 消费税往期实缴税额
	 */
	@ExcelExportStyle(14)
	private Double xfswqsjse;

	/**
	 * 消费税同比增幅
	 */
	@ExcelExportStyle(15)
	private String xfstbzf;

	/**
	 * 企业所得税营业收入
	 */
	@ExcelExportStyle(16)
	private Double qysdsyysr;

	/**
	 * 企业所得税利润总额
	 */
	@ExcelExportStyle(17)
	private Double qysdslrze;

	/**
	 * 企业所得税预计缴纳税额
	 */
	@ExcelExportStyle(18)
	private Double qysdsyjjnse;

	/**
	 * 企业所得税本期实缴
	 */
	@ExcelExportStyle(19)
	private Double qysdsbqsjse;

	/**
	 * 企业所得税往期实缴
	 */
	@ExcelExportStyle(20)
	private Double qysdswqsjse;

	/**
	 * 企业所得税往期实缴
	 */
	@ExcelExportStyle(21)
	private String qysdstbzf;

	/**
	 * 其他税收预计缴纳税额
	 */
	@ExcelExportStyle(22)
	private Double qtssyjjnse;

	/**
	 * 其他税收预计缴纳税额个人所得税
	 */
	@ExcelExportStyle(23)
	private Double qtssgrsdsjyjjnse;

	/**
	 * 其他税收预计缴纳税额土地增值税
	 */
	@ExcelExportStyle(24)
	private Double qtsstdzzsyjjnse;

	/**
	 * 其他税收实际缴纳税额
	 */
	@ExcelExportStyle(25)
	private Double qtssbqsjse;

	/**
	 * 其他税收缴纳税额个人所得税实际缴纳税额
	 */
	@ExcelExportStyle(26)
	private Double qtssgrsdssjse;

	/**
	 * 其他税收缴纳税额土地增值税实际缴纳税额
	 */
	@ExcelExportStyle(27)
	private Double qtsstdzzssjse;

	/**
	 * 其他税收同比增幅
	 */
	@ExcelExportStyle(28)
	private String qtsstbzf;

	/**
	 * 预计税额合计
	 */
	@ExcelExportStyle(29)
	private Double yjsehj;

	/**
	 * 本期实缴税额合计
	 */
	@ExcelExportStyle(30)
	private Double bqsjsehj;

	/**
	 * 往期税额合计
	 */
	@ExcelExportStyle(31)
	private Double wqsjsehj;

	/**
	 * 同比增幅合计
	 */
	@ExcelExportStyle(32)
	private String tbzfhj;
}

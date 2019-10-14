package cn.com.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/**
 * Description:
 * User: wangpl
 * Date: 2019-10-13
 * Time: 22:29
 */
@Data
public class DataMxDo extends BaseRowModel {

    @ExcelProperty(index =0)
    private String xh;
    @ExcelProperty(index =1)
    private String mc;
    @ExcelProperty(index =2)
    private String bq;
    @ExcelProperty(index =3)
    private String tq;
    @ExcelProperty(index =4)
    private String sm;
}

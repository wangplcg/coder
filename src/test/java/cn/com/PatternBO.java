package cn.com;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Description:
 * User: wangpl
 * Date: 2021-03-29
 * Time: 18:05
 */
@Data
public class PatternBO {
    private String id;
    private String originId;
    private BigDecimal diff;
    private Integer type;
    private String level;
    private String color;
    private String name;
    private Long createDate;
}

package cn.com.sun.common;

import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Think
 * Date: 2019-05-06
 * Time: 23:33
 */
@Data
public class ManagerPersonDto implements Serializable {
    private String name;
    private String age;
    private String sex;
}

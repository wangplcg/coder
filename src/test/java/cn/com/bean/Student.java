package cn.com.bean;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Think
 * Date: 2019-02-15
 * Time: 10:25
 */
@Data
public class Student {
    private String name;
    private String age;
    private Teacher teacher;
    private String[] scores = new String[20];

    public String getNamePrint() {
        return name;
    }
}
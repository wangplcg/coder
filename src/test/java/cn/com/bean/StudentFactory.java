package cn.com.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Think
 * Date: 2019-02-15
 * Time: 11:30
 */

public class StudentFactory implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return new Student();
    }

    @Override
    public Class<?> getObjectType() {
        return Student.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}

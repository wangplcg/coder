package cn.com.generic;

import org.junit.Test;

import java.lang.reflect.TypeVariable;

/**
 * Description:
 * User: wangpl
 * Date: 2020-01-08
 * Time: 22:30
 */

public class GenericTest {


    @Test
    public void testGenric() {
        TypeVariable<Class<Student>>[] typeParameters = Student.class.getTypeParameters();
        for (TypeVariable<Class<Student>> typeParameter : typeParameters) {
            System.out.println(typeParameter);
        }

    }
}

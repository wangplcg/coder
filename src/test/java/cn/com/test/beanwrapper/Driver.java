package cn.com.test.beanwrapper;

public class Driver {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "age=" + age +
                '}';
    }
}
package cn.com.asm;

public class Test01 {
    public static void main(String[] args) {
        System.out.println("in test01 main");
        new Test01().process();
    }
    public void process() {
        // 注入打印 "Call step1"，也即 System.out.println("Call " + methodName);
        step1();
        // 注入打印 "Return step1",也即 System.out.println("Return " + methodName);
        
        // 注入打印 "Call step2" 
        step2();
        // 注入打印 "Return step2"
    }

    public void step1() {
        System.out.println("in step1");
    }

    public void step2() {
        System.out.println("in step2");
    }
}

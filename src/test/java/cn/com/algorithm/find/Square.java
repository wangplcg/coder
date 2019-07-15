package cn.com.algorithm.find;

/**
 * Description: 牛顿迭代算法 求解平方根  （x + a/x）* 1/2
  * User: wangpl
 * Date: 2019-07-01
 * Time: 23:19
 */

public class Square {

    public static double getSquare(double d, double target) {
        if (d * d - target < 1e-6) return d;
        return getSquare((d + target/d) * 0.5, target);
    }

    public static void main(String[] args) {
        double square = getSquare(800.0, 30.0);
        System.out.println(square);
    }
}
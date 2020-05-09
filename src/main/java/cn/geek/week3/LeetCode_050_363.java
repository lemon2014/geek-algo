package cn.geek.week3;

/**
 *
 * 计算 x 的 n 次幂函数
 *
 * 1. 暴力解法直接for 循环
 *
 * 2. 分治的思想 n/2 x^(n/2) * x^(n/2) = x^n 需要判断奇偶性
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月25日 14:32:00
 */
public class LeetCode_050_363 {

    /**
     * My pow double.
     *
     * @param x
     *            the x
     * @param n
     *            the n
     * @return the double
     */
    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return fastPow(x, n);
    }

    private double fastPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double half = fastPow(x, n / 2);
        return n % 2 == 0 ? half * half : half * half * x;
    }
}

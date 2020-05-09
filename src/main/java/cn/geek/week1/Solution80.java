package cn.geek.week1;

/**
 * 爬楼梯
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月11日 22:01:00
 */
public class Solution80 {

    public static void main(String[] args) {
        Solution80 solution80 = new Solution80();
        System.out.println(solution80.climbStairs(5));
    }

    /**
     * Climb stairs int.
     *
     * @param n
     *            the n
     * @return the int
     */
    public int climbStairs(int n) {

        // 递归 1、找到递归结束的出口 走5阶梯的走法 = 走4阶梯走法 + 走3阶梯走法 时间复杂度？？？？
        /*   int count = 0;
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
        */

        // 将所有的走法放到数组中, 然后直接取数组的值, 而不是用递归, 降低的时间复杂度 O(n) 空间复杂度 O(n)
        /*if (n == 1) {
            return 1;
        }
        int[] array = new int[n + 1];
        array[1] = 1;
        array[2] = 2;
        for (int i = 3; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];*/

        // 使用临时变量存储, 空间复杂度O(1)
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int first = 1;
        int second = 2;
        int third = 0;
        for (int i = 3; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }

        // 使用数学公式解法暂时不做处理
        return third;
    }

}

package cn.geek.leetcode.no1103;

/**
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月05日 06:31:00
 */
public class Solution {

    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int i = 0;
        while (candies != 0) {
            res[i % num_people] += Math.min(i + 1, candies);
            candies -= Math.min(i + 1, candies);
            i++;
        }
        return res;
    }
}

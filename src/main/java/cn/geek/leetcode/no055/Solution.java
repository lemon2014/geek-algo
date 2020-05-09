package cn.geek.leetcode.no055;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 面试题57 - II. 和为s的连续正数序列 滑动窗口
 *
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月06日 07:13:00
 */
public class Solution {
    public int[][] findContinuousSequence(int target) {

        int left = 1, right = 1, sum = 0;

        List<int[]> res = new ArrayList<>();

        while (left <= target / 2) {
            if (sum < target) {
                sum += right;
                right++;
            } else if (sum > target) {
                sum -= left;
                left++;
            } else {
                // 记录结果
                int[] tempRes = new int[right - left];
                for (int i = left; i < right; i++) {
                    tempRes[i - left] = i;
                }
                res.add(tempRes);

                // 窗口右移
                sum += right;
                right++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] res = solution.findContinuousSequence(9);
        Arrays.asList(res).forEach(t -> System.out.println(t));
    }
}

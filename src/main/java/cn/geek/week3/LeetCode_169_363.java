package cn.geek.week3;

import java.util.Arrays;

/**
 *
 * 求众数 只能有一个数 没有两个并列
 *
 * 出现次数肯定是大于n/2
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月29日 10:09:00
 */
public class LeetCode_169_363 {

    /**
     * 两个for循环,
     *
     * @param nums
     *            the nums
     * @return the int
     */
    public int majorityElement(int[] nums) {
        int maxCount = nums.length / 2;
        for (int num : nums) {
            int count = 0;
            for (int i : nums) {
                if (i == num) {
                    count++;
                }
            }
            if (count > maxCount) {
                return num;
            }
        }
        return -1;
    }

    /**
     * Majority element by sort int.
     *
     * @param nums
     *            the nums
     * @return the int
     */
    public int majorityElementBySort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 投票算法
     *
     * @param nums
     *            the nums
     * @return the int
     */
    public int majorityElement3(int[] nums) {
        int candidate = nums[0], count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}

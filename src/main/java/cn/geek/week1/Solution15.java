package cn.geek.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The type Solution 15. 三个数之和
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月12日 13:03:00
 */
public class Solution15 {

    /**
     * The entry point of application.
     *
     * @param args
     *            the input arguments
     */
    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        List<List<Integer>> resultList = solution15.threeSum(new int[] {-1, 0, 1, 2, -1, -4});
        for (List<Integer> list : resultList) {
            System.out.println(list);
        }
    }

    /**
     * Three sum list.
     *
     * @param nums
     *            the nums
     * @return the list
     */
    public List<List<Integer>> threeSum(int[] nums) {

        /**
         *
         * 1、暴力三层循环 时间复杂度O(n^3)
         *
         * 2、两层循环加 hash 将两个数字的和判断是否在哈希表中
         *
         * 3、双指针 先按顺序排序，然后三个指针 k i j k放到最左端， i放k后面， j放到数组的最后面， 然后i，j 向中间靠拢
         *
         */
        List<List<Integer>> resultList = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 3) {
            return resultList;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> tempList = new ArrayList<>();
                        tempList.add(nums[i]);
                        tempList.add(nums[j]);
                        tempList.add(nums[k]);
                        resultList.add(tempList);
                    }
                }
            }
        }

        // 2、不清楚hash如何实现

        // 3、双指针 先排序
        resultList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                // 如果最小数都大于0，则三个数之和一定不能相等，结束循环
                break;
            }
            int left = i + 1;
            int right = len - 1;

            // 左右指针重合表示遍历结束
            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    resultList.add(Arrays.asList(new Integer[] {nums[i], nums[left], nums[right]}));

                    // 怎么去重？？？？ 排序后相同的数据在一起, 跳过相等的数据就相当于去重
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;

                } else if (sum > 0) {
                    left++;
                } else if (sum < 0) {
                    right--;
                }
            }
        }

        return resultList;
    }
}

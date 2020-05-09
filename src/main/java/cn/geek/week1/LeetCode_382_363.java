package cn.geek.week1;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * 0移动
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月11日 16:31:00
 */
public class LeetCode_382_363 {

    /**
     * Move zeroes. leetcode283
     *
     * @param nums
     *            the nums
     */
    public void moveZeroes(int[] nums) {
        if (null == nums) {
            return;
        }

        // 方法一
        /*   int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
        
        for (int k = 0; k < nums.length; k++) {
            System.out.println(nums[k] + ",");
        }*/

        // 方法二 将非0的前移动，然后将后面的全部设置为0 没有进行数组这件的交换, 直接复制 都是通过双指针来实现,

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        for (; index < nums.length; index++) {
            nums[index] = 0;
        }

        for (int k = 0; k < nums.length; k++) {
            System.out.println(nums[k] + ",");
        }
    }

    public static void main(String[] args) {
        LeetCode_382_363 solution = new LeetCode_382_363();
        solution.moveZeroes(new int[] {0, 1, 0, 3, 12});

        ArrayList list = new ArrayList();
        LinkedList linkedList = new LinkedList();

    }
}

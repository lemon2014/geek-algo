package cn.geek.week1;

/**
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月16日 11:04:00
 */
public class Solution88 {

    /**
     * Merge. 指针从前往后 空间O(m) 时间O(m+n)
     *
     * @param nums1
     *            the nums 1
     * @param m
     *            the m
     * @param nums2
     *            the nums 2
     * @param n
     *            the n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);
        int p1 = 0, p2 = 0, p = 0;
        while (p1 < m && p2 < n) {
            nums1_copy[p++] = nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
        }

        // if there are still elements to add
        if (p1 < m) {

        }

        if (p2 < n) {

        }
    }

    /**
     * Merge 2. 指针从后往前
     *
     * @param nums1
     *            the nums 1
     * @param m
     *            the m
     * @param nums2
     *            the nums 2
     * @param n
     *            the n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {

    }

    public static void main(String[] args) {

    }
}

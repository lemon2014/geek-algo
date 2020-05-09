package cn.geek.leetcode;

import java.util.Arrays;

/**
 * 面试题 10.01. 合并排序的数组
 *
 * <p>
 * 1.直接将数组b放到数组a后面，然后排序</>
 * <p>
 * 2.新建一个数组, 遍历两个数组, 放到新的数组中 </>
 * <p>
 * 3.使用数组a的空间, 遍历两个取最大值从后往前放</>
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月03日 06:27:00
 */
public class Solution {

    /**
     * 时间复杂度O((m+n)log(m+n))
     *
     * @param A
     *            the a
     * @param m
     *            the m
     * @param B
     *            the b
     * @param n
     *            the n
     */
    public void merge(int[] A, int m, int[] B, int n) {
        for (int i = 0; i < n; i++) {
            A[m + i] = B[i];
        }
        Arrays.sort(A);

        for (int j = 0; j < A.length; j++) {
            System.out.println(A[j]);
        }
    }

    /**
     * 时间复杂度O(m+n) 空间复杂度O(m+n)
     *
     * @param A
     *            the a
     * @param m
     *            the m
     * @param B
     *            the b
     * @param n
     *            the n
     */
    public void merge2(int[] A, int m, int[] B, int n) {
        int[] res = new int[m + n];
        int pa = 0;
        int pb = 0;
        int index = 0;
        while (pa < m || pb < n) {
            res[index++] = A[pa] < B[pb] && A[pa] != 0 ? A[pa++] : B[pb++];
        }
        for (int i = 0; i < res.length; i++) {
            A[i] = res[i];
            System.out.println(A[i]);
        }
    }

    /**
     * 时间复杂度O(m+n) 空间复杂度O(1)
     *
     * @param A
     *            the a
     * @param m
     *            the m
     * @param B
     *            the b
     * @param n
     *            the n
     */
    public void merge3(int[] A, int m, int[] B, int n) {
        while (m > 0 && n > 0) {
            A[m + n - 1] = A[m - 1] > B[n - 1] ? A[m-- - 1] : B[n-- - 1];
        }
        while (n > 0) {
            A[n - 1] = B[n - 1];
            n--;
        }
    }

    public static void main(String[] args) {
        int[] A = new int[] {1, 2, 3, 4, 5, 0, 0, 0};
        int[] B = new int[] {1, 5, 6};
        Solution solution = new Solution();
        solution.merge3(A, 5, B, 3);
    }

}

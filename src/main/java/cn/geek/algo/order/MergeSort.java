package cn.geek.algo.order;

/**
 *
 * 并归算法-->分治思想-->递归
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月05日 15:25:00
 */
public class MergeSort {

    /**
     *
     * 递推公式 marge(marge(L, N), marge(N+1, R))
     *
     * 递归结束条件 L >= R
     *
     * 当前层逻辑
     *
     * 下探
     *
     * 清理状态
     *
     */

    public int[] sort(int[] arr, int left, int right) {
        if (left >= right) {
            return new int[] {};
        }
        int[] leftArr = sort(arr, left, right / 2);
        int[] rightArr = sort(arr, right / 2 + 1, right);

        int pLeft = 0;
        int pRight = 0;
        int index = 0;
        int[] temp = new int[leftArr.length + rightArr.length];

        while (pLeft <= leftArr.length && pRight <= rightArr.length) {
            temp[index++] = leftArr[pLeft] < rightArr[pRight] ? leftArr[pLeft++] : rightArr[pRight++];
        }

        if (rightArr.length > leftArr.length) {
            temp[temp.length - 1] = rightArr[rightArr.length - 1];
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] temp = new int[] {5, 6, 3};
        MergeSort sort = new MergeSort();
        int[] res = sort.sort(temp, 0, temp.length - 1);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}

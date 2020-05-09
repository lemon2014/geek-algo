package cn.geek.algo.order;

import java.util.Arrays;

/**
 * 
 * 插入排序
 *
 * 将数组分为有序和无序, 第一个数为有序, 后面为无序, 依次把后面无序的数插入到前面有序的数组中
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月05日 10:26:00
 */
public class InsertionSort {

    public int[] sort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int sorted = i - 1;
            int current = array[i];
            while (sorted >= 0 && array[sorted] > current) {

                // 涉及到插入就需要数组的移动
                array[sorted + 1] = array[sorted];
                sorted--;
            }
            array[sorted + 1] = current;
        }
        return array;
    }

    public static void main(String[] args) {
        InsertionSort sort = new InsertionSort();
        int[] res = sort.sort(new int[] {4, 5, 6, 3, 2, 1});
        Arrays.asList(res).forEach(System.out::println);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

}

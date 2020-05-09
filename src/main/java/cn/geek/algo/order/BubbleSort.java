package cn.geek.algo.order;

import java.util.Arrays;

/**
 * 
 * 冒泡排序 依次比较, 将最大的放到最后
 * 
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月05日 10:25:00
 */
public class BubbleSort {

    public int[] bubbleSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();
        int[] res = bs.bubbleSort(new int[] {4, 5, 6, 3, 2, 1});
        Arrays.asList(res).forEach(System.out::println);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}

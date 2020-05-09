package cn.geek.week1;

/**
 * The type Solution 11.  盛最多水的容器
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月11日 21:27:00
 */
public class Solution11 {

    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        System.out.println(solution11.maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    /**
     * Max area int.
     *
     * @param height
     *            the height
     * @return the int
     */
    public int maxArea(int[] height) {

        // 方法一： 暴力

        /*int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 1; j < height.length; j++) {
                maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
            }
        }*/

        // 方法二： 双指针法 面积=长*宽 长度变小，则高度必须增加，否则面积只会更小 因此始终移动高度较小

        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[right], height[left]));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }

}

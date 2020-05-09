package cn.geek.week3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月25日 15:15:00
 */
public class LeetCode_078_363 {

    /**
     * Subsets list.
     *
     * @param nums
     *            the nums
     * @return the list
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>(1);
        res.add(temp);
        recursive(nums, 0, res);
        return res;
    }

    /**
     * 递归
     *
     * @param nums
     *            the nums
     * @param i
     *            the
     * @param res
     *            the res
     */
    public void recursive(int[] nums, int i, List<List<Integer>> res) {

        // 递归出口
        if (i >= nums.length) {
            return;
        }
        int size = res.size();

        // 当前层逻辑
        for (int j = 0; j < size; j++) {

            // 拷贝一份出来, 然后追加
            List<Integer> newSub = new ArrayList<>(res.get(j));
            newSub.add(nums[i]);
            res.add(newSub);
        }

        // 子层逻辑
        recursive(nums, i + 1, res);
    }

    /**
     * 不用递归,直接暴力枚举
     *
     * @param nums
     *            the nums
     * @return the list
     */
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        res.add(temp);

        for (int i = 0; i < nums.length; i++) {

            // 当前层逻辑
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> newSub = new ArrayList<>(res.get(j));
                newSub.add(nums[i]);
                res.add(newSub);
            }
        }
        return res;
    }

    /**
     * Dfs. 二叉树的preorder, inorder, postoder dfs
     */
    public void dfs(int[] nums, int i, List<Integer> subSet, List<List<Integer>> res) {
        if (i >= nums.length) {
            return;
        }
        subSet = new ArrayList<>(subSet);

        // per-order
        res.add(subSet);
        dfs(nums, i + 1, subSet, res);
        subSet.add(nums[i]);
        dfs(nums, i + 1, subSet, res);

        // in-order
        dfs(nums, i + 1, subSet, res);
        subSet.add(nums[i]);
        res.add(subSet);
        dfs(nums, i + 1, subSet, res);

        // post-order
        dfs(nums, i + 1, subSet, res);
        subSet.add(nums[i]);
        dfs(nums, i + 1, subSet, res);
        res.add(subSet);
    }

    // backtrack 回溯 深度优先遍历
    public void backtrack(int[] nums, int i, List<Integer> sub, List<List<Integer>> res) {

    }

    // 二进制位移的思想
    public String binary(int n) {
        return null;
    }

    public static void main(String[] args) {
        LeetCode_078_363 leetCode = new LeetCode_078_363();
        List<List<Integer>> list = leetCode.subsets2(new int[] {1});
        list.forEach(t -> System.out.println(t));
    }

}

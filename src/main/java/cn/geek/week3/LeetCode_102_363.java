package cn.geek.week3;

import java.util.*;

/**
 * 二叉树的层次遍历
 *
 * 使用广度优先
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月01日 07:49:00
 */
public class LeetCode_102_363 {

    /**
     * Level order list.
     *
     * @param root
     *            the root
     * @return the list
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        makeUp(root, 0, resList);
        return resList;
    }

    /**
     * BFS
     *
     * @param node
     *            the node
     * @param level
     *            the level
     * @param res
     *            the res
     */
    public void makeUp(TreeNode node, int level, List<List<Integer>> res) {
        if (level == res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);

        if (node.left != null) {
            makeUp(node.left, level + 1, res);
        }
        if (node.right != null) {
            makeUp(node.right, level + 1, res);
        }
    }

    /**
     * 使用队列 BFS
     *
     * @param node
     *            the node
     */
    public List<List<Integer>> makeUpByQueue(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;

        while (!queue.isEmpty()) {
            res.add(new ArrayList<>());
            int level_length = queue.size();
            for (int j = 0; j < level_length; ++j) {
                TreeNode node = queue.remove();
                res.get(level).add(node.val);

                if (null != node.left) {
                    queue.add(node.left);
                }
                if (null != node.right) {
                    queue.add(node.right);
                }
            }
            level++;
        }
        return res;
    }

    /**
     * DFS, 前序遍历？？
     *
     * @param curr
     *            the curr
     * @return the list
     */
    public List<List<Integer>> makeUpByDfs(TreeNode curr) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == curr) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
                if (stack.size() > res.size()) {
                    res.add(new ArrayList<>());
                }
            }
            curr = stack.pop();
            List<Integer> list = res.get(stack.size());
            list.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        LeetCode_102_363 leetcode = new LeetCode_102_363();
        leetcode.makeUpByDfs(root).forEach(t -> System.out.println(t));
    }
}

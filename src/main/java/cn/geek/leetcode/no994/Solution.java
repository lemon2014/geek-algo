package cn.geek.leetcode.no994;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 腐烂的橘子 BFS/DFS/递归
 *
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月04日 06:27:00
 */
public class Solution {

    /**
     * Oranges rotting int.
     *
     * @param grid
     *            the grid
     * @return the int
     */
    public static int orangesRotting(int[][] grid) {

        //巧妙的使用下面的两个数组,方便正向的扩散
        int[] xArray = new int[] {-1, 0, 1, 0};
        int[] yArray = new int[] {0, -1, 0, 1};

        Map<Integer, Integer> depth = new HashMap<>();
        Deque<Integer> deque = new ArrayDeque<>();

        int row = grid.length, column = grid[0].length;

        // 找到所有的烂橘子, 入队列
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (grid[r][c] == 2) {
                    int key = r * column + c;
                    deque.add(key);
                    depth.put(key, 0);
                }
            }
        }
        int res = 0;
        while (!deque.isEmpty()) {
            int key = deque.remove();
            int r = key / column;
            int c = key % column;
            for (int i = 0; i < 4; i++) {
                int numR = r + yArray[i];
                int numC = c + xArray[i];

                if (0 <= numR && numR < row && 0 <= numC && numC < column && grid[numR][numC] == 1) {
                    grid[numR][numC] = 2;
                    int temp = numR * column + numC;
                    deque.add(temp);
                    depth.put(temp, depth.get(key) + 1);
                    res = depth.get(temp);
                }
            }
        }

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (grid[r][c] == 1) {
                   return -1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[][] grid = new int[][] {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int[][] grid = new int[][] {{1},{2}};
        System.out.println(orangesRotting(grid));
    }
}

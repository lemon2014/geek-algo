package cn.geek.week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月28日 10:16:00
 */
public class LeetCode_017_363 {

    /**
     * 1、递归 2、深度优先 3、回溯
     *
     * Letter combinations list.
     *
     * @param digits
     *            the digits
     * @return the list
     */
    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();
        Map<Character, String> map = new HashMap<>(8);
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        makeUp(res, digits, 0, "", map);
        return res;
    }

    /**
     * Make up.
     *
     * @param res
     *            the res
     * @param digits
     *            the digits
     * @param i
     *            the
     * @param cur
     *            the cur
     * @param map
     *            the map
     */
    public void makeUp(List<String> res, String digits, int i, String cur, Map<Character, String> map) {

        // 递归结束
        if (digits.length() == i) {
            res.add(cur);
            return;
        }

        // 当前层逻辑 bfs
        String str = map.get(digits.charAt(i));
        for (int j = 0; j < str.length(); j++) {
            makeUp(res, digits, i + 1, cur + str.charAt(j), map);
        }
    }

    public static void main(String[] args) {
        LeetCode_017_363 leetcode = new LeetCode_017_363();
        leetcode.letterCombinations("23").forEach(t -> System.out.println(t));
    }

}

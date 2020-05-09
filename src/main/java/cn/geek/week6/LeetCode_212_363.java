package cn.geek.week6;

import java.util.List;

/**
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月21日 10:48:00
 */
public class LeetCode_212_363 {

    /**
     * Find words list.
     *
     * @param board
     *            the board
     * @param words
     *            the words
     * @return the list
     */
    public List<String> findWords(char[][] board, String[] words) {
        // dfs board 四连通 --> 判断前缀是否存在字典树中

        return null;
    }

    class WordTrie {

        private TrieNode root;

        public WordTrie() {
            root = new TrieNode();
        }

        public void insertWord(String word) {
            if (null == word) {
                return;
            }
            TrieNode cur = root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

            }
        }

        public boolean searchPrefix(String word) {
            return false;
        }

    }

    class TrieNode {
        private TrieNode[] links;
        private final int length = 26;
        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[length];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

}

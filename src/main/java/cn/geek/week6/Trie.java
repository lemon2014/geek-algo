package cn.geek.week6;

/**
 *
 * 如果不是英文字母是汉字
 *
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月18日 07:49:00
 */
public class Trie {

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (null == word) {
            return;
        }
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!cur.containsKey(ch)) {
                cur.put(ch, new TrieNode());
            }
            cur = cur.get(ch);
        }
        cur.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        // 找到前缀节点, 然后BFS 就可以获取所有的单词
        TrieNode curNode = searchNode(word);
        return curNode != null && curNode.isEnd;
    }

    private TrieNode searchNode(String word) {
        if (null == word) {
            return null;
        }
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!cur.containsKey(ch)) {
                return null;
            }
            cur = cur.get(ch);
        }
        return cur;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curNode = searchNode(prefix);
        return curNode != null;
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

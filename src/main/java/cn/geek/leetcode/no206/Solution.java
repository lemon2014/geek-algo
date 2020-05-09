package cn.geek.leetcode.no206;

import cn.geek.leetcode.ListNode;

/**
 * 反转链表 1->2->3->4->5->NULL 5->4->3->2->1->NULL
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月02日 07:31:00
 */
public class Solution {

    /**
     * Reverse list list node.
     *
     * @param node
     *            the node
     * @return the list node
     */
    public ListNode reverseList(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;
        ListNode tmp = null;

        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    /**
     * 递归实现
     *
     * @param node
     *            the node
     * @return the list node
     */
    public ListNode reverseList2(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode cur = reverseList2(node.next);
        node.next.next = node;
        node.next = null;
        return cur;
    }

}

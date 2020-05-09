package cn.geek.week1;

/**
 *
 * 反转一个单链表
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月12日 21:25:00
 */
public class Solution206 {

    /**
     * Reverse list list node.
     *
     * @param head
     *            the head
     * @return the list node
     */
    public ListNode reverseList(ListNode head) {

        // 使用迭代 、递归两种方式解决
        ListNode temp = null;
        ListNode pre = null;
        ListNode cur = head;

        //使用双指针来控制
        while (pre != null) {

        }


        //使用递归方式解决


        return cur;

    }

    /**
     * The entry point of application.
     *
     * @param args
     *            the input arguments
     */
    public static void main(String[] args) {
        Solution206 solution206 = new Solution206();
        ListNode headNode = new ListNode(1);
        headNode.next = new ListNode(2);
        headNode.next.next = new ListNode(3);
        headNode.next.next.next = new ListNode(4);
        headNode.next.next.next.next = new ListNode(5);
        ListNode listNode = solution206.reverseList(headNode);
        // listNode = headNode;

        // 单链表的遍
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}


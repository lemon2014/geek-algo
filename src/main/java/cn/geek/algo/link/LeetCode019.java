package cn.geek.algo.link;

/**
 * 删除链表的倒数第N个节点
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月03日 15:08:00
 */
public class LeetCode019 {

    /**
     * Remove nth from end list node.
     *
     * @param head
     *            the head
     * @param n
     *            the n
     * @return the list node
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // 1、两次遍历 不设置哨兵和设置哨兵有什么区别？ 体验下 2、快慢指针?

        ListNode sentry = new ListNode(0);
        sentry.next = head;
        ListNode faster = sentry;
        ListNode slower = sentry;

        for (int i = 0; i <= n; i++) {
            faster = faster.next;
        }

        while (faster != null) {
            faster = faster.next;
            slower = slower.next;
        }

        slower.next = slower.next.next;
        return sentry.next;
    }

    /**
     * 如果只有一个节点的时候, 会报错, 如果设置哨兵节点就不会存在问题
     *
     * @param head
     * @param n
     * @return
     */
    private ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode faster = head;
        ListNode slower = head;
        for (int i = 0; i <= n; i++) {
            faster = faster.next;
        }

        while (faster != null) {
            faster = faster.next;
            slower = slower.next;
        }
        slower.next = slower.next.next;
        return head;
    }
}

package cn.geek.algo.link;

/**
 * 环形链表
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月03日 15:07:00
 */
public class LeetCode141 {

    /**
     * 使用快慢指针
     *
     * @param head
     *            the head
     * @return the boolean
     */
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        // 这里设置为next 主要是处理list长度为1的情况, 不会执行到faster.next.next 的空指针异常
        ListNode faster = head.next;
        ListNode slower = head;

        while (faster != slower) {
            if (faster == null || faster.next == null) {
                return false;
            }
            faster = faster.next.next;
            slower = slower.next;
        }
        return true;
    }

}

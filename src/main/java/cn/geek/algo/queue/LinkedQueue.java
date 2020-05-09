package cn.geek.algo.queue;

/**
 *
 * 用链表实现队列功能 先进先出 进enqueue 出dequeue
 *
 * 链表是使用的不连续的空间, 所以不需要设置初始化长度
 *
 * 使用数组才需要设置初始化空间
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月04日 13:27:00
 */
public class LinkedQueue {

    private ListNode head;
    private ListNode tail;

    /**
     * 入队
     *
     * @param obj
     *            the obj
     * @return the boolean
     */
    public void enqueue(Integer obj) {

        if (tail == null) {
            ListNode newNode = new ListNode(obj);
            head = newNode;
            tail = newNode;
        } else {
            tail.next = new ListNode(obj);
            tail = tail.next;
        }
    }

    /**
     * 出队
     *
     * @return the integer
     */
    public Integer dequeue() {
        if (head == null) {
            return null;
        }
        int result = head.val;
        head = head.next;

        if (head == null) {
            tail = null;
        }
        return result;
    }

}

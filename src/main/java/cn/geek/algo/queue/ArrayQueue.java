package cn.geek.algo.queue;

/**
 * 用数组实现队列的功能 先进先出 进enqueue 出dequeue
 *
 * 队列的假满
 *
 * 使用链表使用队列的功能
 *
 * 循环队列
 *
 * ArrayBlockingQueue公平锁 Linux环形缓存
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月03日 21:05:00
 */
public class ArrayQueue<T> {

    private Object[] items;
    private int n;

    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity) {
        this.n = capacity;
        items = new Object[n];
    }

    /**
     * Enqueue boolean. 入队
     *
     * @return the boolean
     */
    public boolean enqueue(Object obj) {

        // 队列已满
        if (tail == n) {
            if (head == 0) {
                return false;
            }

            // 这里存在一种假队列满,tail = n, head ！=0 其实队列还有空间
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            tail -= head;
        }
        items[tail++] = obj;
        return true;
    }

    /**
     * Dequeue t. 出队
     *
     * @return the t
     */
    public T dequeue() {

        // 队列为空
        if (tail == head) {
            return null;
        }
        return (T)items[head++];
    }
}

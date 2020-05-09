package cn.geek.week1;

/**
 * 用数组来实现队列 有限队列
 *
 * 队列的主要工作，一个是入队列 enqueue，一个是出队列 dequeue
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月13日 16:06:00
 */
public class ArrayQueue {

    private String[] items;

    private int capacity;

    private int head = 0;

    private int tail = 0;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        items = new String[capacity];
    }

    /**
     * Enqueue boolean. 入队列
     *
     * @param str
     *            the str
     * @return the boolean
     */
    public boolean enqueue(String str) {

        // 入队列和出队列会导致存在空闲位置不可用,使用数据迁移的办法,当没有可用空间并且存在空闲空间的时候,进行数据迁移

        if (tail == capacity) {
            // 表示队列已经满了
            if (head == 0) {

                // 如果队列满了才进行扩展,

                return false;
            }

            // 需要数据迁移 将head到tail之间的数移动到队列头部
            for (int i = head; i < tail; i++) {
                items[head - i] = items[i];
            }
            tail = tail - head;
            head = 0;

        }
        items[tail++] = str;
        return true;
    }

    /**
     * Dequeue string. 出队列
     *
     * @return the string
     */
    public String dequeue() {

        if (head == tail) {
            return null;
        }
        return items[head++];
    }
}

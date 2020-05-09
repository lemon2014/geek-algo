package cn.geek.week1;

/**
 *
 * 环形队列, 可以解决队列频繁插入和弹出导致的数据搬移工作
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月13日 18:50:00
 */
public class CircularQueue {

    private String[] items;
    private int head = 0;
    private int tail = 0;
    private int capacity;

    public CircularQueue(int capacity) {
        items = new String[capacity];
        this.capacity = capacity;
    }

    /**
     * Enqueue boolean. 入队列
     *
     * @param str
     *            the str
     * @return the boolean
     */
    public boolean enqueue(String str) {

        // 判断队列是否满,
        if (head == (tail + 1) % capacity) {
            return false;
        }
        items[tail] = str;
        tail = (tail + 1) % capacity;
        return true;
    }

    /**
     * Dequeue string. 出队列
     *
     * @return the string
     */
    public String dequeue() {

        // 队列为空v bv b
        if (head == tail) {
            return null;
        }
        String result = items[head];
        head = (head + 1) % capacity;
        return result;
    }

}

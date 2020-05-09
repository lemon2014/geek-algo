package cn.geek.leetcode.no225;

import java.util.LinkedList;

/**
 * 使用队列实现栈的功能
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月01日 07:27:00
 */
public class MyStack {

    private LinkedList<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {

        // 放入的时候需要将队列里面数据重新排序

        queue.add(x);
        int size = queue.size();
        while (size > 1) {
            queue.add(queue.remove());
            size--;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.getFirst();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

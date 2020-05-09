package cn.geek.algo.array;

/**
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月02日 16:57:00
 */
public class LinkNode<T> {
    private T element;
    private LinkNode next;

    public LinkNode(T element) {
        this.element = element;
    }

    public LinkNode(T element, LinkNode next) {
        this.element = element;
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public LinkNode getNext() {
        return next;
    }

    public void setNext(LinkNode next) {
        this.next = next;
    }
}

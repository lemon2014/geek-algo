package cn.geek.algo.array;

/**
 *
 * 使用单链表实现LRU缓存 时间复杂度 空间复杂度
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月02日 15:49:00
 */
public class BaseLinkLRUCache<T> {

    private static final int DEFAULT_CAPACITY = (1 << 3);

    private Integer capacity;

    private LinkNode<T> headNode;

    private Integer length;

}

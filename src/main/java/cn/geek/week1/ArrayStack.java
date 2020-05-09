package cn.geek.week1;

/**
 *
 * 用数组来实现栈, 栈数据结构相对简单
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月13日 15:27:00
 */
public class ArrayStack {

    private String[] items;
    private int capacity;
    private int index = 0;


    @Override
    public String toString() {

        for(int j=0; j<items.length; j++) {
            System.out.println(items[j]);
        }
        return items.toString();
    }

    public ArrayStack(int capacity) {
        items = new String[capacity];
        this.capacity = capacity;
    }

    /**
     * Push boolean. 入栈
     *
     * @param str
     *            the str
     * @return the boolean
     */
    public boolean push(String str) {

        // 需要扩容, 涉及到数组的拷贝, 将原数组拷贝到新数组中
        if (index == capacity) {
            String[] newItems = new String[2 * capacity];
            System.arraycopy(items, 0, newItems, 0, items.length);
            items = newItems;
            newItems = null;
        }
        items[index++] = str;
        return true;
    }

    /**
     * Pop string. 出栈
     *
     * @return the string
     */
    public String pop() {

        if (index < 0) {
            return null;
        }
        return items[--index];
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(10);
        for (int i = 0; i < 20; i++) {
            arrayStack.push(String.valueOf(i));
        }
        System.out.println(arrayStack);

        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());

    }
}

package cn.geek.week1;

//import org.apache.commons.lang.StringUtils;

/**
 *
 * 验证是否为回文串
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月13日 14:32:00
 */
public class LeetCode_125_363 {

    /**
     * The entry point of application.
     *
     * @param args
     *            the input arguments
     */
    public static void main(String[] args) {
        // Solution125 solution125 = new Solution125();
        // String str = "A man, a plan, a canal: Panama";
        // boolean result = solution125.isPalindrome(str);
        // System.out.println(result);

        LeetCode_125_363 leetCode = new LeetCode_125_363();

        // 循环初始化列表 从前往后,从后往前
        String str = "A1234554321A";
        ListNode node = coverStr2ListNode2(str);
        printNode(node);
        System.out.println(leetCode.isPalindrome(node));
    }

    private static void printNode(ListNode node) {
        ListNode printNode = node;
        while (printNode != null) {
            System.out.println(printNode.val);
            printNode = printNode.next;
        }
    }

    /**
     * 从头部插入
     *
     * @param str
     * @return
     */
    private static ListNode coverStr2ListNode(String str) {
        ListNode head = new ListNode(0);
        ListNode cur = null;
        for (int i = 0; i < str.length(); i++) {
            // 12345654320
            cur = new ListNode(str.charAt(i));
            cur.next = head.next;
            head.next = cur;
        }
        return head.next;
    }

    /**
     * 从尾部插入
     *
     * @param str
     * @return
     */
    private static ListNode coverStr2ListNode2(String str) {
        ListNode head = new ListNode(0);
        ListNode tmp = head;

        for (int i = 0; i < str.length(); i++) {
            ListNode cur = new ListNode(str.charAt(i));
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = cur;
        }
        return head.next;
    }

    /**
     * Is palindrome boolean.
     *
     * @param s
     *            the s
     * @return the boolean
     */
    public boolean isPalindrome(String s) {

        // 先全部转小写并且去掉空格
//        String tempStr = StringUtils.trim(s);
        String tempStr = "";
        tempStr = tempStr.toLowerCase().replaceAll(":", "").replaceAll(",", "").replaceAll(" ", "");
        System.out.println(tempStr);

        // 利用两个指针两边遍历 时间复杂度O(n)
        int left = 0;
        int right = tempStr.length() - 1;
        while (left < right) {
            if (tempStr.charAt(left++) != tempStr.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * 练习题,这里使用单链表来存储字符串
     *
     * 用快慢指针先找到中点，然后把后半段链表reversed，然后一个指针在头部，一个指针再中点，开始逐个比较，时间复杂度是O（n)
     *
     * @param listNode
     *            the list node
     * @return the boolean
     */
    public boolean isPalindrome(ListNode listNode) {

        // 查找中间节点
        ListNode faster = listNode;
        ListNode slower = listNode;

        // 处理字符串长度为奇数偶数
        while (faster != null && faster.next != null) {
            faster = faster.next.next;
            slower = slower.next;
        }

        // slower是后半段链表,直接单链表反转
        ListNode pre = null;
        ListNode cur = slower;
        ListNode tmp = null;

        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        // pre是反转后的单链表, 直接和原来的前半段链表对比, 一样是回文否则不是
        while (pre.next != null) {
            if (pre.val != listNode.val) {
                return false;
            } else {
                pre = pre.next;
                listNode = listNode.next;
            }
        }
        return true;
    }
}

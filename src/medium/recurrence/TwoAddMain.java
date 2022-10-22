package medium.recurrence;

import java.util.Arrays;
import java.util.List;

/**
 * 两数相加，非递归方法
 *
 * <p>解答成功: 执行耗时:1 ms,击败了100.00% 的Java用户 内存消耗:41.3 MB,击败了84.94% 的Java用户
 *
 * @author by liangzj
 * @since 2022/10/9 23:12
 */
public class TwoAddMain {

    public static void main(String[] args) {
        //
        List<ListNode> listNodes = data2();

        ListNode l3 = addTwoNumbers(listNodes.get(0), listNodes.get(1));
        System.out.println(l3);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(), l3cur = l3;
        int val1, val2, val3, carry = 0;
        do {
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            } else {
                val1 = 0;
            }

            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            } else {
                val2 = 0;
            }

            val3 = val1 + val2 + carry;
            carry = (val3 > 9) ? (val3 / 10) : 0;

            l3cur.next = new ListNode(val3 % 10);
            l3cur = l3cur.next;

        } while (l1 != null || l2 != null || carry != 0);

        return l3.next;
    }

    private static List<ListNode> data1() {
        //
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        return Arrays.asList(l1, l2);
    }

    private static List<ListNode> data2() {
        //
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);

        return Arrays.asList(l1, l2);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

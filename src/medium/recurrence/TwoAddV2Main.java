package medium.recurrence;

import java.util.Arrays;
import java.util.List;

/**
 * 两数相加，递归法
 *
 * <p>解答成功: 执行耗时:1 ms,击败了100.00% 的Java用户 内存消耗:41.3 MB,击败了75.64% 的Java用户
 *
 * @author by liangzj
 * @since 2022/10/9 23:12
 */
public class TwoAddV2Main {

    public static void main(String[] args) {
        //
        List<ListNode> listNodes = data2();

        ListNode l3 = addTwoNumbers(listNodes.get(0), listNodes.get(1));
        System.out.println(l3);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTowNumbers(l1, l2, 0);
    }

    private static ListNode addTowNumbers(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        int val1 = (l1 == null) ? 0 : l1.val;
        int val2 = (l2 == null) ? 0 : l2.val;
        // 当前位相加的和、进位值
        int val3 = val1 + val2 + carry;
        carry = val3 > 9 ? (val3 / 10) : 0;

        l1 = (l1 == null) ? null : l1.next;
        l2 = (l2 == null) ? null : l2.next;

        // 这里当前位的值已经算出来了，递归是为了算下一位的值
        return new ListNode(val3 % 10, addTowNumbers(l1, l2, carry));
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

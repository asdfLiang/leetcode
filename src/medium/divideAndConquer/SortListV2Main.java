package medium.divideAndConquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 148. 排序链表
 *
 * @author by liangzj
 * @since 2022/10/21 23:55
 */
public class SortListV2Main {
    public static void main(String[] args) {
        //
        ListNode head1 = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        ListNode head2 =
                new ListNode(
                        -1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));

        ListNode sorted1 = sortList(head1);
        ListNode sorted2 = sortList(head2);

        System.out.println(sorted1);
        System.out.println(sorted2);
    }

    public static ListNode sortList(ListNode head) {
        List<Integer> values = new ArrayList<>();
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }

        Integer[] array = values.toArray(new Integer[] {});
        Arrays.sort(array);

        ListNode sortHead = new ListNode();
        ListNode tail = sortHead;
        for (Integer i : array) {
            ListNode node = new ListNode(i);
            tail.next = node;
            tail = node;
        }

        return sortHead.next;
    }

    public static class ListNode {
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
}

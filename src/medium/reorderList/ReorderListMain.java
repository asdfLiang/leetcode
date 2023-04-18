package medium.reorderList;

import basic.ListNode;

import utils.LinkedUtil;

/**
 *
 *
 * @since 2023/4/17 22:37
 * @author by liangzj
 */
public class ReorderListMain {
    public static void main(String[] args) {
        Integer[] arr1 = new Integer[] {1, 2, 3, 4};
        ListNode list1 = LinkedUtil.buildList(arr1);

        reorderList(list1);
        LinkedUtil.print(list1);
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode l2 = reverse(slow.next);

        // 断开前后两链表的连接
        slow.next = null;

        mergeList(head, l2);
    }

    private static void mergeList(ListNode l1, ListNode l2) {
        ListNode curr = l1;
        ListNode next;
        ListNode l2next;
        while (l2 != null) {
            next = curr.next;
            l2next = l2.next;

            // l2节点插入l1
            l2.next = next;
            curr.next = l2;

            // 两个链表都后移一个节点，继续操作
            curr = next;
            l2 = l2next;
        }
    }

    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}

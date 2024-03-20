package krahets.easyMiddleNode;

import basic.ListNode;

/**
 * 876. 链表的中间结点(双指针)
 *
 * @since 2024/3/20 23:12
 * @author by liangzj
 */
public class MiddleNodeMain {
    public ListNode middleNode(ListNode head) {
        if (head.next == null) return head;
        if (head.next.next == null) return head.next;

        ListNode half = head, tail = head;

        while (tail != null && tail.next != null) {
            half = half.next;
            tail = tail.next.next;
        }

        return half;
    }
}

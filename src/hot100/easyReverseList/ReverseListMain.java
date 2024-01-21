package hot100.easyReverseList;

import basic.ListNode;

import utils.LinkedUtil;

/**
 * 206. 反转链表
 *
 * @since 2023/9/21 7:23
 * @author by liangzj
 */
public class ReverseListMain {
    public static void main(String[] args) {
        ListNode head = LinkedUtil.buildList(new Integer[] {1, 2, 3, 4, 5});

        System.out.println(reverseList(head));
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        (head.next).next = head;
        head.next = null;
        return newHead;
    }
}

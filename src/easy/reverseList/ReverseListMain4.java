package easy.reverseList;

import basic.ListNode;

import utils.LinkedUtil;

/**
 * 206. 反转链表 (递归)
 *
 * @author by liangzj
 * @since 2023/4/09 23:56
 */
public class ReverseListMain4 {
    public static void main(String[] args) {
        Integer[] arr1 = new Integer[] {1, 1, 2};
        ListNode list1 = LinkedUtil.buildList(arr1);

        LinkedUtil.print(reverseList(list1));
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}

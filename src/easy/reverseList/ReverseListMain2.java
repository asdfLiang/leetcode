package easy.reverseList;

import basic.ListNode;
import utils.LinkedUtil;

/**
 * 206. 反转链表
 *
 * @author by liangzj
 * @since 2023/4/09 23:56
 */
public class ReverseListMain2 {
    public static void main(String[] args) {
        Integer[] arr1 = new Integer[]{1, 1, 2};
        ListNode list1 = LinkedUtil.buildList(arr1);

        LinkedUtil.print(reverseList(list1));
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(-1);
        reverseList(head, head, dummyNode);

        return dummyNode.next;
    }

    public static ListNode reverseList(ListNode current, ListNode head, ListNode dummyNode) {
        if (current.next == null) {
            dummyNode.next = current;
            return current;
        }
        reverseList(current.next, head, dummyNode).next = current;

        if (head.next != null) head.next = null;

        return current;
    }
}

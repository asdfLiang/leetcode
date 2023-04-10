package easy.reverseList;

import basic.ListNode;

import utils.LinkedUtil;

/**
 * 206. 反转链表 (迭代)
 *
 * @author by liangzj
 * @since 2023/4/09 23:56
 */
public class ReverseListMain3 {
    public static void main(String[] args) {
        Integer[] arr1 = new Integer[] {1, 1, 2};
        ListNode list1 = LinkedUtil.buildList(arr1);

        LinkedUtil.print(reverseList(list1));
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}

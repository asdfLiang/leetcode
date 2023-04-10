package easy.reverseList;

import basic.ListNode;
import utils.LinkedUtil;

/**
 * 206. 反转链表
 *
 * @author by liangzj
 * @since 2023/4/09 23:56
 */
public class ReverseListMain {
    public static void main(String[] args) {
        Integer[] arr1 = new Integer[] {1, 1, 2};
        ListNode list1 = LinkedUtil.buildList(arr1);

        LinkedUtil.print(reverseList(list1));
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = null;

        while (head != null) {
            ListNode node = new ListNode(head.val);
            node.next = dummyNode.next;
            dummyNode.next = node;
            head = head.next;
        }

        return dummyNode.next;
    }
}

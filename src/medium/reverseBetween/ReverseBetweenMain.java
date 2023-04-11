package medium.reverseBetween;

import basic.ListNode;

import utils.LinkedUtil;

/**
 * 92. 反转链表 II ()
 *
 * @since 2023/4/11 22:44
 * @author by liangzj
 */
public class ReverseBetweenMain {

    public static void main(String[] args) {
        Integer[] arr1 = new Integer[] {1, 2, 3, 4, 5};
        ListNode list1 = LinkedUtil.buildList(arr1);

        LinkedUtil.print(reverseBetween(list1, 2, 4));
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        // 找到前驱
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        // 找到后继
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 切出中间链表
        ListNode leftNode = pre.next;
        ListNode suc = rightNode.next;
        pre.next = null;
        rightNode.next = null;

        // 反转
        reverse(leftNode);

        // 接回链表
        pre.next = rightNode;
        leftNode.next = suc;

        return dummyNode.next;
    }

    public static void reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
}

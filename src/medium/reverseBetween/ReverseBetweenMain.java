package medium.reverseBetween;

import basic.ListNode;

import utils.LinkedUtil;

import java.util.Stack;

/**
 * 92. 反转链表 II （未解出，保留记录）
 *
 * @since 2023/4/11 0:14
 * @author by liangzj
 */
public class ReverseBetweenMain {

    public static void main(String[] args) {
        Integer[] arr1 = new Integer[] {1, 2, 3, 4, 5};
        ListNode list1 = LinkedUtil.buildList(arr1);

        LinkedUtil.print(reverseBetween(list1, 2, 4));
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        while (1 < left--) pre = pre.next;

        Stack<ListNode> rightStack = new Stack<>();
        ListNode n = head;
        while (0 < right--) {
            rightStack.push(n);
            n = n.next;
        }

        if (rightStack.isEmpty()) {
            return head;
        }

        ListNode rightNode = rightStack.pop();
        ListNode tail = rightNode.next;
        ListNode leftNode = pre.next;
        while (pre != rightNode || pre.next != rightNode) {
            rightNode.next = leftNode.next;
            pre.next = rightNode;

            leftNode.next = tail;
            rightNode = rightStack.pop();
            rightNode.next = leftNode;
            pre = pre.next;
        }

        return dummyNode.next;
    }
}

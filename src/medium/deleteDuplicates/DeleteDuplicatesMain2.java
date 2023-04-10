package medium.deleteDuplicates;

import basic.ListNode;

import utils.LinkedUtil;

/**
 * 82. 删除排序链表中的重复元素 II
 *
 * @since 2023/4/7 21:32
 * @author by liangzj
 */
public class DeleteDuplicatesMain2 {
    public static void main(String[] args) {
        Integer[] arr1 = new Integer[] {1, 2, 2};
        ListNode list1 = LinkedUtil.buildList(arr1);

        LinkedUtil.print(deleteDuplicates(list1));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        Integer duplicateVal = null;

        ListNode current = head;
        head = null;
        ListNode tail = head;
        while (current != null) {
            if (duplicateVal == null) {
                if (current.next != null && current.val == current.next.val) {
                    duplicateVal = current.val;
                }
            } else {
                if (current.val != duplicateVal) {
                    if (current.next == null || current.next.val != current.val) {
                        duplicateVal = null;
                    } else {
                        duplicateVal = current.val;
                    }
                }
            }

            if (duplicateVal == null) {
                if (head == null) {
                    head = current;
                } else {
                    tail.next = current;
                }
                tail = current;
            }
            current = current.next;
            if (tail != null && current == null) tail.next = null;
        }

        return head;
    }
}

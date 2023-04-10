package medium.deleteDuplicates;

import basic.ListNode;

import utils.LinkedUtil;

/**
 * 82. 删除排序链表中的重复元素 II
 *
 * @since 2023/4/7 21:32
 * @author by liangzj
 */
public class DeleteDuplicatesMain3 {
    public static void main(String[] args) {
        Integer[] arr1 = new Integer[] {1, 2, 2};
        ListNode list1 = LinkedUtil.buildList(arr1);

        LinkedUtil.print(deleteDuplicates(list1));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-101);
        dummy.next = head;
        ListNode a = dummy;
        ListNode b = head;
        while (b != null && b.next != null) {
            if (a.next.val != b.next.val) {
                a = a.next;
            } else {
                while (b.next != null && b.val == b.next.val) {
                    b = b.next;
                }
                a.next = b.next;
            }
            b = b.next;
        }
        return dummy.next;
    }
}

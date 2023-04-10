package easy.deleteDuplicates;

import basic.ListNode;

import utils.LinkedUtil;

/**
 * 83. 删除排序链表中的重复元素
 *
 * @since 2023/4/6 22:56
 * @author by liangzj
 */
public class DeleteDuplicatesMain2 {
    public static void main(String[] args) {
        Integer[] arr1 = new Integer[] {1, 1, 2};
        ListNode list1 = LinkedUtil.buildList(arr1);

        LinkedUtil.print(deleteDuplicates(list1));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode current = head;
        while (current != null) {
            while (current.next != null && current.val == current.next.val) {
                current.next = current.next.next;
            }
            current = current.next;
        }

        return head;
    }
}

package easy.mergeTwoLists;

import basic.ListNode;

import utils.LinkedUtil;

/**
 * 21. 合并两个有序链表
 *
 * @since 2023/4/16 23:04
 * @author by liangzj
 */
public class MergeTwoListsMain {
    public static void main(String[] args) {
        Integer[] l1 = new Integer[] {1, 2, 4};
        Integer[] l2 = new Integer[] {1, 3, 4};
        ListNode ls1 = LinkedUtil.buildList(l1);
        ListNode ls2 = LinkedUtil.buildList(l2);

        LinkedUtil.print(mergeTwoLists(ls1, ls2));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (list1 != null || list2 != null) {
            if (list1 != null && (list2 == null || list1.val <= list2.val)) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
                tail.next = null;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
                tail.next = null;
            }
        }

        return dummy.next;
    }
}

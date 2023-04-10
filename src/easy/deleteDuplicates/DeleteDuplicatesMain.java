package easy.deleteDuplicates;

import basic.ListNode;

import utils.LinkedUtil;

/**
 * 83. 删除排序链表中的重复元素
 *
 * @since 2023/4/6 22:56
 * @author by liangzj
 */
public class DeleteDuplicatesMain {
    public static void main(String[] args) {
        Integer[] arr1 = new Integer[] {1, 1, 2};
        ListNode list1 = LinkedUtil.buildList(arr1);


        LinkedUtil.print(deleteDuplicates(list1));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode a = head;
        ListNode b = a;

        while (a != null) {
            // 如果b等于a，一直向后移动
            while (b != null && b.val == a.val) {
                b = b.next;
            }
            // 找到第一个不等于a的值
            a.next = b;
            a = b;
        }

        return head;
    }
}

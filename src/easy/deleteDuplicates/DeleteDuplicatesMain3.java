package easy.deleteDuplicates;

import basic.ListNode;

import utils.LinkedUtil;

/**
 * 83. 删除排序链表中的重复元素
 *
 * @since 2023/4/6 22:56
 * @author by liangzj
 */
public class DeleteDuplicatesMain3 {
    public static void main(String[] args) {
        Integer[] arr1 = new Integer[] {1, 1, 2};
        ListNode list1 = LinkedUtil.buildList(arr1);

        LinkedUtil.print(deleteDuplicates(list1));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 先深入到最后一个节点
        ListNode next = deleteDuplicates(head.next);
        // 递归的跳出过程，这里首次的next是最后一个节点，head是倒数第二个节点
        // 如果head.val == next.val，那么next节点会被干掉(head.next = next.next，越过了next)
        // 这里每一步都保证了相同的next被干掉，所以next.next一定不等于head
        head.next = (head.val != next.val) ? next : next.next;

        return head;
    }
}

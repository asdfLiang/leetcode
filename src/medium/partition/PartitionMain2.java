package medium.partition;

import basic.ListNode;

import utils.LinkedUtil;

/**
 * 86. 分隔链表
 *
 * @since 2023/4/17 1:22
 * @author by liangzj
 */
public class PartitionMain2 {
    public static void main(String[] args) {
        Integer[] l1 = new Integer[] {1, 4, 3, 2, 5, 2};
        //        Integer[] l2 = new Integer[] {2, 1};
        Integer[] l3 = new Integer[] {1, 4, 3, 0, 2, 5, 2};
        ListNode ls1 = LinkedUtil.buildList(l1);
        //        ListNode ls2 = LinkedUtil.buildList(l2);
        ListNode ls3 = LinkedUtil.buildList(l3);

        LinkedUtil.print(partition(ls3, 3));
        //        LinkedUtil.print(partition(ls2, 2));
    }

    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode preSmall = dummy;
        ListNode preBig = null;
        ListNode small;
        while (preSmall.next != null) {
            if (preBig == null && preSmall.next.val >= x) {
                preBig = preSmall;
            } else if (preBig != null && preSmall.next.val < x) {
                small = preSmall.next;
                // 跳过small节点
                preSmall.next = small.next;
                // 插入small节点
                small.next = preBig.next;
                preBig.next = small;
                // 指向首个大等于x的节点前一个节点
                preBig = small;
            } else {
                preSmall = preSmall.next;
            }
        }

        return dummy.next;
    }
}

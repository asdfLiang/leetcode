package hot100.mediumSwapPairs;

import basic.ListNode;

/**
 * 24. 两两交换链表中的节点
 *
 * @since 2023/10/7 23:24
 * @author by liangzj
 */
public class SwapPairsMain {
    public static void main(String[] args) {}

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode cur0 = dummy;
        ListNode cur1 = dummy.next;
        ListNode cur2;
        while (cur1 != null && cur1.next != null) {
            cur2 = cur1.next;
            cur1.next = cur2.next;
            cur2.next = cur1;
            cur0.next = cur2;

            cur0 = cur1;
            cur1 = cur0.next;
        }

        return dummy.next;
    }
}

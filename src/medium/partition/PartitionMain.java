package medium.partition;

import basic.ListNode;

import utils.LinkedUtil;

/**
 * 86. 分隔链表
 *
 * @since 2023/4/16 23:49
 * @author by liangzj
 */
public class PartitionMain {
    public static void main(String[] args) {
        Integer[] l1 = new Integer[] {1, 4, 3, 2, 5, 2};
        //        Integer[] l2 = new Integer[] {2, 1};
        ListNode ls1 = LinkedUtil.buildList(l1);
        //        ListNode ls2 = LinkedUtil.buildList(l2);

        LinkedUtil.print(partition(ls1, 3));
        //        LinkedUtil.print(partition(ls2, 2));
    }

    public static ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }

        // 找到目标节点，截取出来
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode target = dummy;
        ListNode temp;
        while (target.next != null) {
            if (target.next.val == x) {
                temp = target.next;
                target.next = temp.next;
                target = temp;
                target.next = null;
                head = dummy.next;
                break;
            }
            target = target.next;
        }

        if (target == dummy || dummy.next == null) {
            return head;
        }

        dummy.next = target;
        ListNode pre = dummy;
        ListNode tailPre = target;
        while (head != null) {
            if (head.val < x) {
                temp = head;
                head = head.next;
                temp.next = target;
                pre.next = temp;
                pre = temp;
            } else {
                tailPre.next = head;
                tailPre = head;
                head = head.next;
                tailPre.next = null;
            }
        }

        return dummy.next;
    }
}

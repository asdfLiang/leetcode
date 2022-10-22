package medium.divideAndConquer;

/**
 * 148. 排序链表
 *
 * @author by liangzj
 * @since 2022/10/21 23:55
 */
public class SortListMain {
    public static void main(String[] args) {
        //
        ListNode head1 = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        ListNode head2 =
                new ListNode(
                        -1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));

        ListNode sorted1 = sortList(head1);
        ListNode sorted2 = sortList(head2);

        System.out.println(sorted1);
        System.out.println(sorted2);
    }

    public static ListNode sortList(ListNode head) {
        ListNode sortHead = new ListNode();
        ListNode cur = sortHead;

        while (head != null) {
            ListNode node = new ListNode(head.val);
            if (sortHead.next == null) {
                sortHead.next = node;
                head = head.next;
                continue;
            }

            while (cur != null && cur.next != null && cur.next.val < node.val) {
                cur = cur.next;
            }

            node.next = cur.next;
            cur.next = node;

            head = head.next;
            cur = sortHead;
        }

        return sortHead.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

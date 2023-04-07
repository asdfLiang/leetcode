package medium.deleteDuplicates;

import basic.ListNode;

import utils.LinkedUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 82. 删除排序链表中的重复元素 II
 *
 * @since 2023/4/7 21:32
 * @author by liangzj
 */
public class DeleteDuplicatesMain {
    public static void main(String[] args) {
        Integer[] arr1 = new Integer[] {1, 2, 2};
        ListNode list1 = LinkedUtil.buildList(arr1);

        LinkedUtil.print(deleteDuplicates(list1));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        Queue<ListNode> queue = new LinkedList<>();
        Integer duplicateVal = null;

        ListNode current = head;
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
                queue.offer(current);
            }
            current = current.next;
        }

        if (!queue.isEmpty()) {
            head = queue.poll();
            head.next = null;
            current = head;
            while (!queue.isEmpty()) {
                current.next = queue.poll();
                current = current.next;
                current.next = null;
            }
        } else {
            head = null;
        }

        return head;
    }
}

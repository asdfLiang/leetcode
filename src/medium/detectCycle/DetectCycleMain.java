package medium.detectCycle;

import basic.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 142. 环形链表 II(再看下快慢指针写法)
 *
 * @since 2023/4/19 0:16
 * @author by liangzj
 */
public class DetectCycleMain {
    public static void main(String[] args) {}

    public static ListNode detectCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();

        while (head != null) {
            if (!nodeSet.add(head)) {
                return head;
            }
            head = head.next;
        }

        return null;
    }
}

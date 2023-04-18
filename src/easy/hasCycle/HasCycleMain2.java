package easy.hasCycle;

import basic.ListNode;

import utils.LinkedUtil;

/**
 * 141. ª∑–Œ¡¥±Ì
 *
 * @since 2023/4/18 23:34
 * @author by liangzj
 */
public class HasCycleMain2 {
    public static void main(String[] args) {
        Integer[] arr1 = new Integer[] {1, 2};
        ListNode list1 = LinkedUtil.buildList(arr1, 0);

        System.out.println(hasCycle(list1));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        return true;
    }
}

package easy.hasCycle;

import basic.ListNode;

import utils.LinkedUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. ª∑–Œ¡¥±Ì
 *
 * @since 2023/4/18 23:34
 * @author by liangzj
 */
public class HasCycleMain {
    public static void main(String[] args) {
        Integer[] arr1 = new Integer[] {1, 2};
        ListNode list1 = LinkedUtil.buildList(arr1, 0);

        System.out.println(hasCycle(list1));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        Set<ListNode> nodeSet = new HashSet<>();

        while (head != null) {
            if (!nodeSet.add(head)) {
                return true;
            }
            nodeSet.add(head);
            head = head.next;
        }

        return false;
    }
}

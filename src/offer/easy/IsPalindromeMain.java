package offer.easy;

import basic.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer II 027. 回文链表
 *
 * @since 2023/6/27 0:48
 * @author by liangzj
 */
public class IsPalindromeMain {
    public static void main(String[] args) {}

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode point = head;

        while (point != null) {
            stack.push(point);
            point = point.next;
        }

        int middle = (stack.size() + 1) / 2;
        point = head;
        for (int i = 0; i < middle; i++) {
            ListNode pop = stack.pop();
            if (point.val != pop.val) return false;
            point = point.next;
        }

        return true;
    }
}

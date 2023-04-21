package easy.isPalindrome;

import basic.ListNode;

/**
 * 234. 回文链表
 *
 * @since 2023/4/21 23:37
 * @author by liangzj
 */
public class IsPalindromeMain {
    public static void main(String[] args) {}

    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }

        if (head.next.next == null && head.val != head.next.val) {
            return false;
        }

        ListNode after = head.next;
        ListNode frontEnd = head;
        // 找到前半截的终点
        while (after != null && after.next != null) {
            after = after.next.next;
            frontEnd = frontEnd.next;
        }

        // 分成两段
        after = reverseList(frontEnd.next);
        frontEnd.next = null;

        while (head != null && after != null) {
            if (head.val != after.val) return false;
            head = head.next;
            after = after.next;
        }

        return true;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp;

        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}

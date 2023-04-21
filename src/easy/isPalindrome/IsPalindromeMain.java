package easy.isPalindrome;

import basic.ListNode;

/**
 * 234. ��������
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
        // �ҵ�ǰ��ص��յ�
        while (after != null && after.next != null) {
            after = after.next.next;
            frontEnd = frontEnd.next;
        }

        // �ֳ�����
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

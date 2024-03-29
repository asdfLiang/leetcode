package utils;

import basic.ListNode;

/**
 * @since 2023/4/6 23:07
 * @author by liangzj
 */
public class LinkedUtil {

    public static ListNode buildList(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    public static ListNode buildList(Integer[] arr, Integer pos) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }

        ListNode tail = head;
        if (pos != null && pos > 0) {
            while (pos-- > 0) tail = tail.next;
            cur.next = tail;
        }
        return head;
    }

    public static void print(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
}

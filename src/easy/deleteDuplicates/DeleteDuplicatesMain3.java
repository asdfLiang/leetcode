package easy.deleteDuplicates;

import basic.ListNode;

import utils.LinkedUtil;

/**
 * 83. ɾ�����������е��ظ�Ԫ��
 *
 * @since 2023/4/6 22:56
 * @author by liangzj
 */
public class DeleteDuplicatesMain3 {
    public static void main(String[] args) {
        Integer[] arr1 = new Integer[] {1, 1, 2};
        ListNode list1 = LinkedUtil.buildList(arr1);

        LinkedUtil.print(deleteDuplicates(list1));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // �����뵽���һ���ڵ�
        ListNode next = deleteDuplicates(head.next);
        // �ݹ���������̣������״ε�next�����һ���ڵ㣬head�ǵ����ڶ����ڵ�
        // ���head.val == next.val����ônext�ڵ�ᱻ�ɵ�(head.next = next.next��Խ����next)
        // ����ÿһ������֤����ͬ��next���ɵ�������next.nextһ��������head
        head.next = (head.val != next.val) ? next : next.next;

        return head;
    }
}

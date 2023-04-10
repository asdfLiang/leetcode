package easy.deleteDuplicates;

import basic.ListNode;

import utils.LinkedUtil;

/**
 * 83. ɾ�����������е��ظ�Ԫ��
 *
 * @since 2023/4/6 22:56
 * @author by liangzj
 */
public class DeleteDuplicatesMain {
    public static void main(String[] args) {
        Integer[] arr1 = new Integer[] {1, 1, 2};
        ListNode list1 = LinkedUtil.buildList(arr1);


        LinkedUtil.print(deleteDuplicates(list1));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode a = head;
        ListNode b = a;

        while (a != null) {
            // ���b����a��һֱ����ƶ�
            while (b != null && b.val == a.val) {
                b = b.next;
            }
            // �ҵ���һ��������a��ֵ
            a.next = b;
            a = b;
        }

        return head;
    }
}

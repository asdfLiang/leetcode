package daily.hard.mergeKLists;

import basic.ListNode;

import java.util.*;

/**
 * 23. 合并 K 个升序链表（超时）
 *
 * @since 2023/8/12 9:29
 * @author by liangzj
 */
public class MergeKListsMain {
    public static void main(String[] args) {}

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        int arrayLen = lists.length;

        ListNode result = null;
        ListNode tailPoint = result;
        int preMin = Integer.MIN_VALUE;
        while (true) {
            // 找出本趟的所有数据
            Map<ListNode, Integer> wait = new HashMap<>();
            for (int i = 0; i < arrayLen; i++) {
                ListNode kNode = lists[i];
                if (kNode != null) wait.put(kNode, i);
            }
            if (wait.isEmpty()) break;

            // 找最小节点
            ListNode minNode = null;
            Set<ListNode> waitSet = wait.keySet();
            for (ListNode node : waitSet) {
                if (minNode == null) minNode = node;
                else if (node.val == preMin) minNode = node;
                else if (node.val < minNode.val) minNode = node;
            }
            preMin = minNode.val;

            // 将节点从列表拿出来
            Integer i = wait.get(minNode);
            lists[i] = minNode.next;

            // 合并到结果
            if (result == null) {
                result = new ListNode(minNode.val);
                tailPoint = result;
            } else {
                tailPoint.next = new ListNode(minNode.val);
                tailPoint = tailPoint.next;
            }
        }

        return result;
    }
}

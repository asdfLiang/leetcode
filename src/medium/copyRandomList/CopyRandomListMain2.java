package medium.copyRandomList;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. 复制带随机指针的链表
 *
 * @since 2023/4/22 0:24
 * @author by liangzj
 */
public class CopyRandomListMain2 {
    public static void main(String[] args) {}

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // 编号节点map
        Map<Node, Node> copiedMap = new HashMap<>();

        Node point = head;
        while (point != null) {
            Node copyNode = new Node(point.val);
            // 记录原节点和copy节点的对应关系
            copiedMap.put(point, copyNode);
            point = point.next;
        }

        point = head;
        while (point != null) {
            Node copy = copiedMap.get(point);
            copy.next = copiedMap.get(point.next);
            copy.random = copiedMap.get(point.random);
            point = point.next;
        }

        return copiedMap.get(head);
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}

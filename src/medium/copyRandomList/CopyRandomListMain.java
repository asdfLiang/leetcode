package medium.copyRandomList;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. ���ƴ����ָ�������
 *
 * @since 2023/4/22 0:24
 * @author by liangzj
 */
public class CopyRandomListMain {
    public static void main(String[] args) {}

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node copyDummy = new Node(-1);
        Node copyPrev = copyDummy;
        Node point = head;
        // ��Žڵ�map
        Map<Node, Node> copiedMap = new HashMap<>();

        // ��������
        while (point != null) {
            Node copyNode = new Node(point.val);
            // ��¼ԭ�ڵ��copy�ڵ�Ķ�Ӧ��ϵ
            copiedMap.put(point, copyNode);
            copyPrev.next = copyNode;
            copyPrev = copyNode;
            point = point.next;
        }

        // ����random
        point = head;
        Node copyPoint = copyDummy.next;
        while (point != null) {
            copyPoint.random = copiedMap.get(point.random);
            point = point.next;
            copyPoint = copyPoint.next;
        }

        return copyDummy.next;
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

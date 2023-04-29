package medium.cloneGraph;

import basic.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 133. 克隆图
 *
 * @since 2023/4/29 17:06 - 17:15
 * @author by liangzj
 */
public class CloneGraphMain {
    public static void main(String[] args) {}

    public Node cloneGraph(Node node) {
        Map<Node, Node> cloneMap = new HashMap<>();
        return cloneGraph(node, cloneMap);
    }

    /**
     * @param origin 原节点
     * @param cloneMap Map<原节点，克隆节点>
     * @return 克隆节点
     */
    public Node cloneGraph(Node origin, Map<Node, Node> cloneMap) {
        if (origin == null) return null;

        // 存在复制节点直接返回
        Node clone = cloneMap.get(origin);
        if (clone != null) return clone;

        // 复制当前节点
        clone = new Node(origin.val);
        cloneMap.put(origin, clone);

        // 复制邻接节点
        clone.neighbors = new ArrayList<>();
        for (Node neighbor : origin.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor, cloneMap));
        }

        return clone;
    }
}

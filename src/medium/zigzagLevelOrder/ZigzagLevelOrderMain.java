package medium.zigzagLevelOrder;

import basic.TreeNode;

import utils.BinaryTreeUtil;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 *
 * @since 2023/4/5 18:39
 * @author by liangzj
 */
public class ZigzagLevelOrderMain {

    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtil.buildTree(new Integer[] {3, 9, 20, null, null, 15, 7});

        System.out.println(zigzagLevelOrder(root1));
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        boolean reverse = false;
        List<List<Integer>> res = new ArrayList<>();
        Queue<Queue<TreeNode>> levelQueue = new LinkedList<>();
        levelQueue.offer(
                new LinkedList<>() {
                    {
                        add(root);
                    }
                });

        while (!levelQueue.isEmpty()) {
            // 获取当前层的所有节点
            Queue<TreeNode> currentLevelNodes = levelQueue.poll();
            if (currentLevelNodes.isEmpty()) {
                continue;
            }

            List<Integer> currentLevelVales = new ArrayList<>();
            Queue<TreeNode> nextLevelNodes = new LinkedList<>();

            for (TreeNode node : currentLevelNodes) {
                // 记录当前层的值
                currentLevelVales.add(node.val);
                // 记录下一层节点
                if (node.left != null) {
                    nextLevelNodes.add(node.left);
                }
                if (node.right != null) {
                    nextLevelNodes.add(node.right);
                }
            }

            // 是否反向记录
            if (reverse) {
                Collections.reverse(currentLevelVales);
            }
            res.add(currentLevelVales);

            if (!nextLevelNodes.isEmpty()) {
                levelQueue.offer(nextLevelNodes);
            }
            reverse = !reverse;
        }

        return res;
    }
}

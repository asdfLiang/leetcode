package medium.levelOrder;

import basic.TreeNode;

import utils.BinaryTreeUtil;

import java.util.*;

/**
 * 102. �������Ĳ������
 *
 * @since 2023/4/5 18:07
 * @author by liangzj
 */
public class LevelOrderMain {

    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtil.buildTree(new Integer[] {3, 9, 20, null, null, 15, 7});

        System.out.println(levelOrder(root1));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<Queue<TreeNode>> levelQueue = new LinkedList<>();
        levelQueue.offer(
                new LinkedList<>() {
                    {
                        add(root);
                    }
                });

        while (!levelQueue.isEmpty()) {
            // ��ȡ��ǰ������нڵ�
            Queue<TreeNode> currentLevelNodes = levelQueue.poll();
            if (currentLevelNodes.isEmpty()) {
                continue;
            }

            List<Integer> currentLevelVales = new ArrayList<>();
            Queue<TreeNode> nextLevelNodes = new LinkedList<>();

            for (TreeNode node : currentLevelNodes) {
                // ��¼��ǰ���ֵ
                currentLevelVales.add(node.val);
                // ��¼��һ��ڵ�
                if (node.left != null) {
                    nextLevelNodes.add(node.left);
                }
                if (node.right != null) {
                    nextLevelNodes.add(node.right);
                }
            }
            res.add(currentLevelVales);

            if (!nextLevelNodes.isEmpty()) {
                levelQueue.offer(nextLevelNodes);
            }
        }

        return res;
    }
}

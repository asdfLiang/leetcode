package medium.levelOrderBottom;

import basic.TreeNode;

import utils.BinaryTreeUtil;

import java.util.*;

/**
 * 107. 二叉树的层序遍历 II
 *
 * @since 2023/4/5 18:07
 * @author by liangzj
 */
public class LevelOrderBottomMain {

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
            res.add(currentLevelVales);

            if (!nextLevelNodes.isEmpty()) {
                levelQueue.offer(nextLevelNodes);
            }
        }

        return reverse(res);
    }

    private static <T> List<T> reverse(List<T> list) {
        int size = list.size();

        if (size <= 1) {
            return list;
        }

        T temp;
        for (int i = 0; i < size; i++) {
            int reverseIdx = size - i - 1;
            if (reverseIdx <= i) {
                break;
            }

            temp = list.get(i);
            list.set(i, list.get(reverseIdx));
            list.set(reverseIdx, temp);
        }
        return list;
    }
}

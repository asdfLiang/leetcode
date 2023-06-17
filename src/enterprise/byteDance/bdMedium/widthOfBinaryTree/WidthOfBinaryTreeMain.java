package enterprise.byteDance.bdMedium.widthOfBinaryTree;

import basic.TreeNode;

import utils.BinaryTreeUtil;

import java.util.*;

/**
 * 662. 二叉树最大宽度（字节跳动 10 日心动计划） -- 超时
 *
 * @since 2023/6/17 8:50
 * @author by liangzj
 */
public class WidthOfBinaryTreeMain {
    public static void main(String[] args) {
        TreeNode root1 =
                BinaryTreeUtil.buildTree(new Integer[] {1, 3, 2, 5, null, null, 9, 6, null, 7});
        WidthOfBinaryTreeMain obj = new WidthOfBinaryTreeMain();

        System.out.println(obj.widthOfBinaryTree(root1));
    }

    public int widthOfBinaryTree(TreeNode root) {
        Deque<TreeNode> lastLayout =
                new LinkedList<>() {
                    {
                        add(root);
                    }
                };

        int maxWeight = 1;
        while (true) {
            Deque<TreeNode> nextLayout = new LinkedList<>();
            maxWeight = Math.max(maxWeight, lastLayout.size());
            while (!lastLayout.isEmpty()) {
                TreeNode node = lastLayout.poll();
                if (node == null) {
                    nextLayout.offer(null);
                    nextLayout.offer(null);
                } else {
                    nextLayout.offer(node.left);
                    nextLayout.offer(node.right);
                }
            }

            if (nextLayout.stream().allMatch(Objects::isNull)) {
                return Math.max(maxWeight, trimQueue(lastLayout).size());
            }

            lastLayout = nextLayout;
        }
    }

    private Deque<TreeNode> trimQueue(Deque<TreeNode> deque) {
        // 清除头部null
        while (!deque.isEmpty() && deque.peekFirst() == null) deque.removeFirst();

        // 清除尾部null
        while (!deque.isEmpty() && deque.peekLast() == null) deque.removeLast();

        return deque;
    }
}

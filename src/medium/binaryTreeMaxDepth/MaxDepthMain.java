package medium.binaryTreeMaxDepth;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. 二叉树的最大深度
 *
 * @since 2023/4/2 21:03
 * @author by liangzj
 */
public class MaxDepthMain {

    public static void main(String[] args) {
        Integer[] arr = new Integer[] {3, 9, 20, null, null, 15, 7};
        TreeNode root = buildTree(arr);

        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 构建二叉树
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * @param arr [3,9,20,null,null,15,7]
     * @return 二叉树根节点
     */
    private static TreeNode buildTree(Integer[] arr) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        queue.offer(root);

        int index = 0;
        while (index < arr.length - 1) {
            TreeNode temp = queue.poll();
            if (temp == null) {
                break;
            }

            Integer i1 = arr[++index];
            Integer i2 = arr[++index];

            temp.left = (i1 == null) ? null : new TreeNode(i1);
            temp.right = (i2 == null) ? null : new TreeNode(i2);

            if (i1 != null) queue.offer(temp.left);
            if (i2 != null) queue.offer(temp.right);
        }

        return root;
    }
}

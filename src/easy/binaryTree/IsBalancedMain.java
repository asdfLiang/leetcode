package easy.binaryTree;

import basic.TreeNode;

import utils.BinaryTreeUtil;

/**
 * 110. 平衡二叉树
 *
 * @since 2023/4/2 22:19
 * @author by liangzj
 */
public class IsBalancedMain {
    public static void main(String[] args) {
        Integer[] arr = new Integer[] {3, 9, 20, null, null, 15, 7};
        Integer[] arr1 = new Integer[] {1, 2, 2, 3, 3, null, null, 4, 4};

        TreeNode root = BinaryTreeUtil.buildTree(arr);
        System.out.println(isBalanced(root));

        TreeNode root1 = BinaryTreeUtil.buildTree(arr1);
        System.out.println(isBalanced(root1));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

package medium.isValidBST;

import basic.TreeNode;

import utils.BinaryTreeUtil;

/**
 * 98. ÑéÖ¤¶þ²æËÑË÷Ê÷
 *
 * @since 2023/4/5 19:10
 * @author by liangzj
 */
public class IsValidBSTMain {

    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtil.buildTree(new Integer[] {2, 1, 3});
        TreeNode root2 = BinaryTreeUtil.buildTree(new Integer[] {5, 1, 4, null, null, 3, 6});
        TreeNode root3 = BinaryTreeUtil.buildTree(new Integer[] {5, 4, 6, null, null, 3, 7});

        System.out.println(isValidBST(root1));
        System.out.println(isValidBST(root2));
        System.out.println(isValidBST(root3));
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left != null && root.val <= maxVal(root.left)) {
            return false;
        }

        boolean ltRight = true;
        if (root.right != null && root.val >= minVal(root.right)) {
            return false;
        }

        return isValidBST(root.left) && isValidBST(root.right);
    }

    public static int maxVal(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        return Math.max(Math.max(maxVal(root.left), maxVal(root.right)), root.val);
    }

    public static int minVal(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        return Math.min(Math.min(minVal(root.left), minVal(root.right)), root.val);
    }
}

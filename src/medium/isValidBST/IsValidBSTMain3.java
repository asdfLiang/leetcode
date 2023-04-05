package medium.isValidBST;

import basic.TreeNode;

import utils.BinaryTreeUtil;

/**
 * 98. ÑéÖ¤¶þ²æËÑË÷Ê÷
 *
 * @since 2023/4/5 19:10
 * @author by liangzj
 */
public class IsValidBSTMain3 {

    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtil.buildTree(new Integer[] {2, 1, 3});
        TreeNode root2 = BinaryTreeUtil.buildTree(new Integer[] {5, 1, 4, null, null, 3, 6});
        TreeNode root3 = BinaryTreeUtil.buildTree(new Integer[] {5, 4, 6, null, null, 3, 7});

        System.out.println(isValidBST(root1));
        System.out.println(isValidBST(root2));
        System.out.println(isValidBST(root3));
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isValidBST(TreeNode root, int lower, int upper) {
        if (root == null) {
            return true;
        }

        if (root.val <= lower || root.val >= upper) {
            return false;
        }

        return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
    }
}

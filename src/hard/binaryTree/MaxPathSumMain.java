package hard.binaryTree;

import basic.TreeNode;

import utils.BinaryTreeUtil;

/**
 * 124. 二叉树中的最大路径和 (未解答)
 *
 * @since 2023/4/3 21:19
 * @author by liangzj
 */
public class MaxPathSumMain {
    public static void main(String[] args) {
        Integer[] arr = new Integer[] {1, 2, 3};
        Integer[] arr1 = new Integer[] {-3};
        Integer[] arr2 = new Integer[] {2, -1};
        Integer[] arr3 =
                new Integer[] {9, 6, -3, null, null, -6, 2, null, null, 2, null, -6, -6, -6};
        Integer[] arr4 = new Integer[] {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};

        //        TreeNode root = BinaryTreeUtil.buildTree(arr);
        //        TreeNode root1 = BinaryTreeUtil.buildTree(arr1);
        //        TreeNode root2 = BinaryTreeUtil.buildTree(arr2);
        //        TreeNode root3 = BinaryTreeUtil.buildTree(arr3);
        TreeNode root4 = BinaryTreeUtil.buildTree(arr4);

        //        System.out.println(maxPathSum(root));
        //        System.out.println(maxPathSum(root1));
        //        System.out.println(maxPathSum(root2));
        //        System.out.println(maxPathSum(root3));
        System.out.println(maxPathSum(root4));
    }

    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int val = root.val;
        int leftVal = maxPathSum(root.left);
        int rightVal = maxPathSum(root.right);
        int subMax = Math.max(leftVal, rightVal);
        int sum = val + Math.max(leftVal, 0) + Math.max(rightVal, 0);

        return subMax > val ? subMax : sum;
    }
}

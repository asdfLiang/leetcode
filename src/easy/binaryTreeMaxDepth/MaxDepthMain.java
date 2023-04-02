package easy.binaryTreeMaxDepth;

import basic.TreeNode;import utils.BinaryTreeUtil;


/**
 * 104. 二叉树的最大深度
 *
 * @since 2023/4/2 21:03
 * @author by liangzj
 */
public class MaxDepthMain {

    public static void main(String[] args) {
        Integer[] arr = new Integer[] {3, 9, 20, null, null, 15, 7};
        TreeNode root = BinaryTreeUtil.buildTree(arr);

        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

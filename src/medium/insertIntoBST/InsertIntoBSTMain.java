package medium.insertIntoBST;

import basic.TreeNode;

import utils.BinaryTreeUtil;

/**
 * 701. 二叉搜索树中的插入操作
 *
 * <p>时间 0 ms 击败 100% 内存 41.8 MB 击败 90.61%
 *
 * @since 2023/4/6 21:13
 * @author by liangzj
 */
public class InsertIntoBSTMain {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtil.buildTree(new Integer[] {4, 2, 7, 1, 3});

        TreeNode root = insertIntoBST(root1, 5);
        BinaryTreeUtil.print(root);
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        // 根节点为空
        if (root == null) {
            return new TreeNode(val);
        }

        // 左右有一边为空的情况，且正好val可以补空，这样插入的数据一定是叶子节点
        if (val < root.val && root.left == null) {
            root.left = new TreeNode(val);
        } else if (val > root.val && root.right == null) {
            root.right = new TreeNode(val);
        } else {
            // 没找到合适位置，继续找
            insertIntoBST((val > root.val ? root.right : root.left), val);
        }
        return root;
    }
}

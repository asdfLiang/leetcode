package easy.inorderTraversal;

import basic.TreeNode;

import utils.BinaryTreeUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 *
 * @since 2023/4/29 16:26
 * @author by liangzj
 */
public class InorderTraversalMain {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtil.buildTree(new Integer[] {1, null, 2, 3});

        inorderTraversal(root1).forEach(System.out::println);
    }

    static List<Integer> res = new LinkedList<>();

    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }

        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }
}

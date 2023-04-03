package medium.lowestCommonAncestor;

import basic.TreeNode;

import utils.BinaryTreeUtil;

/**
 * 236. 二叉树的最近公共祖先（看过解析）
 *
 * @since 2023/4/3 23:41
 * @author by liangzj
 */
public class LowestCommonAncestorMain {
    public static void main(String[] args) {
        TreeNode root1 =
                BinaryTreeUtil.buildTree(new Integer[] {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});

        System.out.println(lowestCommonAncestor(root1, root1.left, root1.right).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 找到叶子节点了，跳出，说明之前的节点都不是p或q的祖先
        if (root == null) {
            return null;
        }

        // 找到到了p或q，说明之前的节点都是p或q的祖先
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果左右的都不为空，说明分别在root的左右找到了p和q，root就是公共祖先，因为是在递归的跳出过程，所以是最近的
        if (left != null && right != null) {
            return root;
        }

        // 能走到这里说明是p或q其中之一的祖先，但是不是另一个的祖先
        return left == null ? right : left;
    }
}

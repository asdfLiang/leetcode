package medium.isValidBST;

import basic.TreeNode;

import utils.BinaryTreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 98. 验证二叉搜索树
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
        if (root == null) {
            return true;
        }

        List<Integer> midOrderList = new ArrayList<>();
        return middleOrder(root, midOrderList);
    }

    public static boolean middleOrder(TreeNode root, List<Integer> midOrderList) {
        if (root == null) {
            return true;
        }

        boolean left = middleOrder(root.left, midOrderList);
        // 判断当前节点是否大于
        int size = midOrderList.size();
        boolean flag = size < 1 || root.val > midOrderList.get(size - 1);
        midOrderList.add(root.val);

        return left && flag && middleOrder(root.right, midOrderList);
    }
}

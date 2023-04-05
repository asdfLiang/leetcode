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
public class IsValidBSTMain2 {

    public static void main(String[] args) {
        //        TreeNode root1 = BinaryTreeUtil.buildTree(new Integer[] {2, 1, 3});
        //        TreeNode root2 = BinaryTreeUtil.buildTree(new Integer[] {5, 1, 4, null, null, 3,
        // 6});
        TreeNode root3 = BinaryTreeUtil.buildTree(new Integer[] {5, 4, 6, null, null, 3, 7});

        //        System.out.println(isValidBST(root1));
        //        System.out.println(isValidBST(root2));
        System.out.println(isValidBST(root3));
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        List<Integer> midOrderList = new ArrayList<>();
        middleOrder(root, midOrderList);

        int size = midOrderList.size();
        if (size <= 1) {
            return true;
        }

        int preMaxVal = midOrderList.get(0);
        // 后面的如果小于等于前面的，说明不是搜索二叉树
        for (int i = 1; i < size; i++) {
            Integer currentVal = midOrderList.get(i);
            if (currentVal <= preMaxVal) {
                return false;
            }
            preMaxVal = currentVal;
        }

        return true;
    }

    public static void middleOrder(TreeNode root, List<Integer> midOrderList) {
        if (root == null) {
            return;
        }

        middleOrder(root.left, midOrderList);
        midOrderList.add(root.val);
        middleOrder(root.right, midOrderList);
    }
}

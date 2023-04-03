package utils;

import basic.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树通用工具
 *
 * @since 2023/4/2 22:10
 * @author by liangzj
 */
public class BinaryTreeUtil {

    /**
     * 构建二叉树
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * @param arr [3,9,20,null,null,15,7]
     * @return 二叉树根节点
     */
    public static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        queue.offer(root);

        int index = 0;
        int len = arr.length - 1;
        while (index < len) {
            TreeNode temp = queue.poll();
            if (temp == null) {
                break;
            }

            Integer i1 = (index + 1) <= len ? arr[++index] : null;
            Integer i2 = (index + 1) <= len ? arr[++index] : null;

            if (i1 != null) queue.offer(temp.left = new TreeNode(i1));
            if (i2 != null) queue.offer(temp.right = new TreeNode(i2));
        }

        return root;
    }
}

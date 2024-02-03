package hot100.easySortedArrayToBST;

import basic.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 *
 * @since 2024/2/3 18:21
 * @author by liangzj
 */
public class SortedArrayToBSTMain {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 1) return new TreeNode(nums[0]);

        return buildTree(0, nums.length, nums);
    }

    public TreeNode buildTree(int low, int high, int[] nums) {
        // 跳出条件：1.low >= nums.length || low > high, 返回null 2.low == high，返回nums[low]
        if (low >= nums.length || low > high) return null;
        if (low == high) return new TreeNode(nums[low]);

        // 计算当前的根节点
        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        // 递归计算左节点
        root.left = buildTree(low, mid - 1, nums);

        // 递归计算右节点
        root.right = buildTree(mid + 1, high, nums);

        // 返回根节点
        return root;
    }
}

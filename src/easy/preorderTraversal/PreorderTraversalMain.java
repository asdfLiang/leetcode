package easy.preorderTraversal;

import basic.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 144. 二叉树的前序遍历（迭代算法）
 *
 * @since 2024/3/6 9:37
 * @author by liangzj
 */
public class PreorderTraversalMain {
    /** 个人思路：找到哪些操作的过程是需要倒过来的，这道题里访问右节点是倒过来的(根据递归过程考虑)，所以放到栈里的是右节点 */
    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode curr = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        while (curr != null) {
            res.add(curr.val);

            if (curr.right != null) stack.push(curr.right); // 右节点入栈
            if (curr.left != null) curr = curr.left; // 指针指向左节点
            else if (!stack.isEmpty()) curr = stack.pop(); // 指针指到右节点(左节点为空时)
            else break; // 左、右节点都为空，结束
        }

        return res;
    }
}

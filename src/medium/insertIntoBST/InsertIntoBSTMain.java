package medium.insertIntoBST;

import basic.TreeNode;

import utils.BinaryTreeUtil;

/**
 * 701. �����������еĲ������
 *
 * <p>ʱ�� 0 ms ���� 100% �ڴ� 41.8 MB ���� 90.61%
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
        // ���ڵ�Ϊ��
        if (root == null) {
            return new TreeNode(val);
        }

        // ������һ��Ϊ�յ������������val���Բ��գ��������������һ����Ҷ�ӽڵ�
        if (val < root.val && root.left == null) {
            root.left = new TreeNode(val);
        } else if (val > root.val && root.right == null) {
            root.right = new TreeNode(val);
        } else {
            // û�ҵ�����λ�ã�������
            insertIntoBST((val > root.val ? root.right : root.left), val);
        }
        return root;
    }
}

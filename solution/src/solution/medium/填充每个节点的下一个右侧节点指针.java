package solution.medium;

import algorithm.tree.TreeNode;

public class 填充每个节点的下一个右侧节点指针 {

    public static TreeNode connect(TreeNode root) {
        if(root == null) {
            return null;
        }
        connectTwoNode(root.left, root.right);
        return root;
    }

    private static void connectTwoNode(TreeNode left, TreeNode right) {
        if(left == null || right == null) {
            return;
        }
        left.next = right;
        connectTwoNode(left.left, left.right);
        connectTwoNode(right.left, right.right);
        connectTwoNode(left.right, right.left);
    }

    public static void main(String[] args) {

    }
}

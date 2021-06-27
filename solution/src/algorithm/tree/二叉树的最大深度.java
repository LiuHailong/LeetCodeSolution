package algorithm.tree;

import java.util.List;

public class 二叉树的最大深度 {

    private static int answer = 0;
    /**
     * 自顶向下
     * 递归的方式去算 二叉树的最大深度
     *
     * @param root
     * @return
     */
    public static Integer maxDepthByRecursive(TreeNode root) {
        int depth = 1;
        recursive(root, depth);
        return answer;
    }

    public static void recursive(TreeNode root, int depth) {
        if (null == root) {
            return;
        }

        if(root.left == null && root.right == null) {
            answer = Math.max(answer, depth);
        }

        recursive(root.left, depth + 1);
        recursive(root.right, depth + 1);
    }

    /**
     * 自底向上的后续遍历
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if(null == root) {
            return 0;
        }
        int left_max_depth = maxDepth(root.left);
        int right_max_depth = maxDepth(root.right);
        return Math.max(left_max_depth, right_max_depth) + 1;
    }

    public static void main(String[] args) {
        // 二叉树构建：[3,9,20,null,null,15,7]
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);
        TreeNode n20 = new TreeNode(20, n15, n7);
        TreeNode n9 = new TreeNode(9);
        TreeNode root = new TreeNode(3, n9, n20);


        int answer = maxDepthByRecursive(root);
        System.out.println(answer);
    }
}

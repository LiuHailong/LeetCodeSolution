package algorithm.tree;

/**
 * 给你二叉树的根节点root 和一个表示目标和的整数targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 */
public class 路径总和 {

    /**
     * 累加法 从一个节点到最后一个叶子节点累加和
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSumHelper(root, 0, targetSum);
    }

    public boolean hasPathSumHelper(TreeNode root, int sum, int targetSum) {
        if(root == null) {
            return false;
        }

        sum += root.val;
        if(root.left == null && root.right == null) {
            return sum == targetSum;
        }

        return hasPathSumHelper(root.left, sum, targetSum) || hasPathSumHelper(root.right, sum, targetSum);
    }

    /**
     * 相减的方法, 遍历到叶子节点时, 叶子节点的值 = targetSum - 遍历过的节点的值, 则表示存在这样的路径
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if(null == root) {
            return false;
        }

        if(root.left == null && root.right == null && root.val == targetSum) {
            return true;
        }
        targetSum -= root.val;

        return hasPathSum2(root.left, targetSum) || hasPathSum2(root.right, targetSum);

    }

    public static void main(String[] args) {
        // 二叉树构建：[3,9,20,null,null,15,7]
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);
        TreeNode n20 = new TreeNode(20, n15, n7);
        TreeNode n9 = new TreeNode(9);
        TreeNode root = new TreeNode(3, n9, n20);

        路径总和 o = new 路径总和();
        System.out.println(o.hasPathSum(root, 12));
        System.out.println(o.hasPathSum2(root, 12));
    }
}

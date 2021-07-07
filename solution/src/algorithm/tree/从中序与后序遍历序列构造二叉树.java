package algorithm.tree;

/**
 * 根据一棵树的中序遍历和后续遍历构造二叉树
 * <p>
 * 前序: 根->左->右
 * 中序: 左->根->右
 * 后续: 左->右->根
 */
public class 从中序与后序遍历序列构造二叉树 {

    /**
     * 解题思路:
     * 后续遍历的最后一个节点比为根节点, 然后从中序遍历里面找到这个节点, 把中序遍历的数组一分为2, 左侧为左子树, 右侧为右子树
     * 然后再进行如上的操作
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inorderLength = inorder.length;
        int postorderLength = postorder.length;
        if (inorderLength != postorderLength) {
            return null;
        }
        return buildTreeHelper(inorder, postorder, 0, inorderLength - 1, 0, postorderLength - 1);
    }

    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int head1, int tail1, int head2, int tail2) {
        if (head2 > tail2) {
            return null;
        }

        int rootValue = postorder[tail2];
        TreeNode root = new TreeNode(rootValue);
        if (head2 == tail2) {
            return root;
        }

        int mid = 0;
        while (inorder[head1 + mid] != rootValue) mid++;

        root.left = buildTreeHelper(inorder, postorder, head1, head1 + mid - 1, head2, head2 + mid - 1);
        root.right = buildTreeHelper(inorder, postorder, head1 + mid + 1, tail1, head2 + mid, tail2 - 1);

        return root;
    }

    public static void main(String[] args) {
        // 中序遍历 inorder = [9,3,15,20,7]
        // 后序遍历 postorder = [9,15,7,20,3]

        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        从中序与后序遍历序列构造二叉树 o = new 从中序与后序遍历序列构造二叉树();
        TreeNode treeNode = o.buildTree(inorder, postorder);
    }
}

package algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 树的前序遍历 {
    /**
     * 迭代方法
     * 前序遍历: 根->左->右
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        // 结束条件
        if (null == root) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            list.add(treeNode.val);
            // 因为是 根->左->右的顺序, 所以要先压入右子树入栈
            if(null != treeNode.right) {
                stack.push(treeNode.right);
            }
            if(null != treeNode.left) {
                stack.push(treeNode.left);
            }
        }

        return list;
    }

    /**
     * 递归方法
     * 前序遍历: 根->左->右
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversalByRecursive(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();

        recursive(list, root);

        return list;
    }

    public static void recursive(List<Integer> list, TreeNode root) {
        // 结束条件
        if(null == root) {
            return;
        }

        // 递归
        list.add(root.val);
        recursive(list, root.left);
        recursive(list, root.right);
    }

    public static void main(String[] args) {
        // 前序遍历, 树构建
        TreeNode root = new TreeNode(1);
        TreeNode r1 = new TreeNode(2);
        root.left = null;
        root.right = r1;
        TreeNode l1 = new TreeNode(3);
        r1.left = l1;
        r1.right = null;

        List<Integer> result = preorderTraversal(root);
        System.out.println(result);
    }
}

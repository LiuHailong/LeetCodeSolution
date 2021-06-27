package algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 树的中序遍历 {
    /**
     * 迭代方法
     * 中序遍历: 左->根->右
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        // 结束条件
        if (null == root) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (null != root || !stack.isEmpty()) { // 如果树没处理完 或者 栈没处理完
            while(null != root) { // 一直把左子树压栈
                stack.push(root);
                root = root.left;
            }
            if(! stack.isEmpty()) { // 栈不为空
                TreeNode treeNode = stack.pop();
                list.add(treeNode.val);
                root = treeNode.right;
            }
        }

        return list;
    }

    /**
     * 递归方法
     * 中序遍历: 左->根->右
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversalByRecursive(TreeNode root) {
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
        recursive(list, root.left);
        list.add(root.val);
        recursive(list, root.right);
    }

    public static void main(String[] args) {
        // 树构建
        TreeNode root = new TreeNode(1);
        TreeNode r1 = new TreeNode(2);
        root.left = null;
        root.right = r1;
        TreeNode l1 = new TreeNode(3);
        r1.left = l1;
        r1.right = null;

        List<Integer> result = inorderTraversal(root);
        System.out.println(result);
    }
}

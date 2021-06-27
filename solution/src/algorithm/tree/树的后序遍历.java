package algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 树的后序遍历 {
    /**
     * 迭代方法
     * 后序遍历: 左->右->根
     *
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        // 结束条件
        if (null == root) {
            return list;
        }
        stack.push(root);
        // 根据这段代码画出栈的图 会更加形象 更好理解
        while (!stack.isEmpty()) {
            root = stack.pop();
            if (null != root) {
                stack.push(root);
                stack.push(null);
                if(root.right != null) {
                    stack.push(root.right);
                }
                if(root.left != null) {
                    stack.push(root.left);
                }
            } else {
                list.add(stack.pop().val);
            }
        }

        return list;
    }

    /**
     * 递归方法
     * 后序遍历: 左->右->根
     *
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversalByRecursive(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();

        recursive(list, root);

        return list;
    }

    public static void recursive(List<Integer> list, TreeNode root) {
        // 结束条件
        if (null == root) {
            return;
        }

        // 递归
        recursive(list, root.left);
        recursive(list, root.right);
        list.add(root.val);
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

        List<Integer> result = postorderTraversal(root);
        System.out.println(result);
    }
}

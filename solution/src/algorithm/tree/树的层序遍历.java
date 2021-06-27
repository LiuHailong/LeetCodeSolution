package algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 树的层序遍历 {

    /**
     * 使用递归, 记录了一个level层级, 各个层级有各自对应的arrayList
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        levelOrder(list, root, 0);

        return list;
    }

    private static void levelOrder(List<List<Integer>> list, TreeNode root, int level) {
        if(null == root) {
            return;
        }

        if(level >= list.size()) {
            list.add(new ArrayList<>());
        }

        list.get(level).add(root.val);
        levelOrder(list, root.left, level + 1);
        levelOrder(list, root.right, level + 1);
    }

    /**
     * 使用队列的方式
     *
     * @param root
     */
    public static List<List<Integer>> levelOrderByQueue(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(null == root) {
            return list;
        }
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList();
            list.add(temp);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
        }


        return list;
    }

    public static void main(String[] args) {
        // 二叉树构建：[3,9,20,null,null,15,7]
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);
        TreeNode n20 = new TreeNode(20, n15, n7);
        TreeNode n9 = new TreeNode(9);
        TreeNode root = new TreeNode(3, n9, n20);


//        List<List<Integer>> result = levelOrder(root);
        List<List<Integer>> result = levelOrderByQueue(root);
        System.out.println(result);
    }
}

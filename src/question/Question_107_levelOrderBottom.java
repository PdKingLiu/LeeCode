package question;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author liupeidong
 * Created on 2019/8/27 11:15
 */
public class Question_107_levelOrderBottom {

    /*给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

        例如：
        给定二叉树 [3,9,20,null,null,15,7],

            3
           / \
          9  20
            /  \
           15   7
        返回其自底向上的层次遍历为：

        [
          [15,7],
          [9,20],
          [3]
        ] */

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(new ArrayList<>());
        }
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<List<Integer>> lists = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            TreeNode treeNode;
            for (int i = 0; i < size; i++) {
                treeNode = queue.poll();
                list.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            lists.addFirst(list);
        }
        return lists;
    }
}

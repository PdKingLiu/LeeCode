package question;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author liupeidong
 * Created on 2019/8/26 21:30
 */
public class Question_102_levelOrder {

    /*给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

        例如:
        给定二叉树: [3,9,20,null,null,15,7],

            3
           / \
          9  20
            /  \
           15   7
        返回其层次遍历结果：

        [
          [3],
          [9,20],
          [15,7]
        ] */

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(new ArrayList<>());
        }
        List<List<Integer>> lists = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> listTem = new LinkedList<>();
            TreeNode treeNode;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                treeNode = queue.poll();
                listTem.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            lists.add(listTem);
        }
        return lists;
    }
}

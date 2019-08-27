package question;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/8/27 12:19
 */
public class Question_103_zigzagLevelOrder {

    /*给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

        例如：
        给定二叉树 [3,9,20,null,null,15,7],

            3
           / \
          9  20
            /  \
           15   7
        返回锯齿形层次遍历如下：

        [
          [3],
          [20,9],
          [15,7]
        ] */

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(new ArrayList<>());
        }
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        List<List<Integer>> lists = new LinkedList<>();
        queue1.add(root);
        boolean flag = true;
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            int size;
            TreeNode treeNode;
            List<Integer> tem = new LinkedList<>();
            if (flag) {
                size = queue1.size();
                for (int i = 0; i < size; i++) {
                    treeNode = queue1.getFirst();
                    tem.add(treeNode.val);
                    if (treeNode.left != null) {
                        queue2.addFirst(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue2.addFirst(treeNode.right);
                    }
                    queue1.removeFirst();
                }
                flag = false;
            } else {
                size = queue2.size();
                for (int i = 0; i < size; i++) {
                    treeNode = queue2.getFirst();
                    tem.add(treeNode.val);
                    if (treeNode.right != null) {
                        queue1.addFirst(treeNode.right);
                    }
                    if (treeNode.left != null) {
                        queue1.addFirst(treeNode.left);
                    }
                    queue2.removeFirst();
                }
                flag = true;
            }
            lists.add(tem);
        }
        return lists;
    }
}

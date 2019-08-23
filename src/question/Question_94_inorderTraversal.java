package question;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/8/22 21:25
 */

public class Question_94_inorderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> list = new LinkedList<>();

    /*中序递归遍历*/

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }

    /*中序非递归遍历——栈*/

    public List<Integer> inorderTraversal2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode treeNode = stack.pop();
            list.add(treeNode.val);
            root = treeNode.right;
        }
        return list;
    }
}

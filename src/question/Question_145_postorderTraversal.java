package question;

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/8/24 21:05
 */
public class Question_145_postorderTraversal {

    /*给定一个二叉树，返回它的 后序 遍历。

        示例:

        输入: [1,null,2,3]
           1
            \
             2
            /
           3

        输出: [3,2,1]
        进阶: 递归算法很简单，你可以通过迭代算法完成吗？ */

    LinkedList<Integer> list = new LinkedList<>();

    /*递归*/

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }

    /*非递归 栈*/

    public List<Integer> postorderTraversal2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                list.addFirst(root.val);
                stack.push(root);
                root = root.right;
            }
            root = stack.pop().left;
        }
        return list;
    }

}

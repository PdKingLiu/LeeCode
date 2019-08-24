package question;

import common.TreeNode;

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

    List<Integer> list = new LinkedList<>();

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
}

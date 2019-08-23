package question;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/8/23 16:53
 */
public class Question_144_preorderTraversal {



    List<Integer> list = new LinkedList<>();

    /*二叉树的先序遍历*/

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }
}

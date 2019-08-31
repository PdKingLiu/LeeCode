package question;

import common.TreeNode;

/**
 * @author liupeidong
 * Created on 2019/8/31 10:54
 */
public class Question_110_isBalanced {

    /*给定一个二叉树，判断它是否是高度平衡的二叉树。

        本题中，一棵高度平衡二叉树定义为：

        一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。

        示例 1:

        给定二叉树 [3,9,20,null,null,15,7]

            3
           / \
          9  20
            /  \
           15   7
        返回 true 。

        示例 2:

        给定二叉树 [1,2,2,3,3,null,null,4,4]

               1
              / \
             2   2
            / \
           3   3
          / \
         4   4
        返回 false 。 */

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}

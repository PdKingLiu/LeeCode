package question;

import common.TreeNode;

/**
 * @author liupeidong
 * Created on 2019/8/31 11:17
 */
public class Question_112_hasPathSum {

    /*给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

        说明: 叶子节点是指没有子节点的节点。

        示例: 
        给定如下二叉树，以及目标和 sum = 22，

                      5
                     / \
                    4   8
                   /   / \
                  11  13  4
                 /  \      \
                7    2      1
        返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。 */

    int add = 0;
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        add += root.val;
        if (root.right == null && root.left == null) {
            if (add == sum) {
                add -= root.val;
                return true;
            } else {
                add -= root.val;
                return false;
            }
        }
        boolean b1 = hasPathSum(root.left, sum);
        boolean b2 = hasPathSum(root.right, sum);
        add -= root.val;
        return b1 || b2;
    }
}

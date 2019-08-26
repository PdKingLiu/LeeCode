package question;

import common.TreeNode;

/**
 * @author liupeidong
 * Created on 2019/8/24 22:03
 */
public class Question_98_isValidBST {

    /*给定一个二叉树，判断其是否是一个有效的二叉搜索树。

        假设一个二叉搜索树具有如下特征：

        节点的左子树只包含小于当前节点的数。
        节点的右子树只包含大于当前节点的数。
        所有左子树和右子树自身必须也是二叉搜索树。
        示例 1:

        输入:
            2
           / \
          1   3
        输出: true
        示例 2:

        输入:
            5
           / \
          1   4
             / \
            3   6
        输出: false
        解释: 输入为: [5,1,4,null,null,3,6]。
             根节点的值为 5 ，但是其右子节点值为 4 。 */

    /* 上下界递归 */

    boolean isTrue = true;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return DFS( root.left, root.val, null) && DFS(root.right, null, root.val);
    }

    private boolean DFS(TreeNode now, Integer upper,Integer lower) {
        if (now == null) {
            return true;
        }
        if (!isTrue) {
            return false;
        }
        boolean[] thisValid = {false, false};
        if (upper != null) {
            if (now.val < upper) {
                thisValid[0] = true;
            }
        }else {
            thisValid[0] = true;
        }
        if (lower != null) {
            if (now.val > lower) {
                thisValid[1] = true;
            }
        }else {
            thisValid[1] = true;
        }
        if (!(thisValid[0] && thisValid[1])) {
            isTrue = false;
        }
        return thisValid[0] && thisValid[1] && (DFS(now.left, now.val, lower) && DFS(now.right, upper, now.val));
    }

}

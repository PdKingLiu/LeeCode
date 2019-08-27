package question;

import common.TreeNode;

/**
 * @author liupeidong
 * Created on 2019/8/27 16:23
 */
public class Question_104_maxDepth {

    /*给定一个二叉树，找出其最大深度。

        二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

        说明: 叶子节点是指没有子节点的节点。

        示例：
        给定二叉树 [3,9,20,null,null,15,7]，

            3
           / \
          9  20
            /  \
           15   7
        返回它的最大深度 3 。 */

    int max = 0;

    public int maxDepth(TreeNode root) {
        DFS(root, 0);
        return max;
    }

    private void DFS(TreeNode root, int depth) {
        if (root == null) {
            return;
        } else {
            max = Math.max(max, depth + 1);
        }
        DFS(root.left, depth + 1);
        DFS(root.right, depth + 1);
    }
}

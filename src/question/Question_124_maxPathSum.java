package question;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liupeidong
 * Created on 2019/11/13 13:33
 */
public class Question_124_maxPathSum {

    /*给定一个非空二叉树，返回其最大路径和。

        本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。

        示例 1:

        输入: [1,2,3]

               1
              / \
             2   3

        输出: 6
        示例 2:

        输入: [-10,9,20,null,null,15,7]

           -10
           / \
          9  20
            /  \
           15   7

        输出: 42 */

    /*
     * DFS+BFS 200ms
     * */

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int MAX = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                sum = 0;
                max = 0;
                int leftMax = 0;
                int rightMax = 0;
                DFS(treeNode.left);
                leftMax = max;
                sum = 0;
                max = 0;
                DFS(treeNode.right);
                rightMax = max;
                MAX = Math.max(MAX, leftMax + rightMax + treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
        }
        return MAX;
    }

    int sum = Integer.MIN_VALUE;
    int max = Integer.MIN_VALUE;

    private void DFS(TreeNode root) {
        if (root == null) {
            return;
        }
        sum += root.val;
        max = Math.max(max, sum);
        DFS(root.left);
        DFS(root.right);
        sum -= root.val;
    }

}

package question;

import common.TreeNode;

import java.util.ArrayList;

/**
 * @author liupeidong
 * Created on 2019/8/31 12:06
 */
public class Question_114_flatten {

    /*给定一个二叉树，原地将它展开为链表。

        例如，给定二叉树

            1
           / \
          2   5
         / \   \
        3   4   6
        将其展开为：

        1
         \
          2
           \
            3
             \
              4
               \
                5
                 \
                  6 */

    ArrayList<Integer> list = new ArrayList<>(2000);

    public void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        getList(root);
        root.left = null;
        for (int i = 1; i < list.size(); i++) {
            root.right = new TreeNode(list.get(i));
            root = root.right;
        }
    }

    private void getList(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        getList(root.left);
        getList(root.right);
    }

    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode rightTem;
        while (root != null) {
            if (root.left != null) {
                rightTem = root.right;
                root.right = root.left;
                root.left = null;
                if (rightTem != null) {
                    TreeNode rightBottom = root.right;
                    while (rightBottom.right != null) {
                        rightBottom = rightBottom.right;
                    }
                    rightBottom.right = rightTem;
                }
            }
            root = root.right;
        }
    }
}

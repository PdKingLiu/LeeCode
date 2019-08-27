package question;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/8/27 17:51
 */
public class Question_99_recoverTree {

    /*二叉搜索树中的两个节点被错误地交换。

        请在不改变其结构的情况下，恢复这棵树。

        示例 1:

        输入: [1,3,null,null,2]

           1
          /
         3
          \
           2

        输出: [3,1,null,null,2]

           3
          /
         1
          \
           2
        示例 2:

        输入: [3,1,4,null,null,2]

          3
         / \
        1   4
           /
          2

        输出: [2,1,4,null,null,3]

          2
         / \
        1   4
           /
          3
        进阶:

        使用 O(n) 空间复杂度的解法很容易实现。
        你能想出一个只使用常数空间的解决方案吗？ */

    /*空间复杂度O（n）*/

    boolean[] isChanged = {false, false};
    List<Integer> list = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        DFS(root);
        Collections.sort(list);
        int[] arr = new int[2];
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if ((int) list.get(i) != (int) list2.get(i)) {
                arr[count++] = list.get(i);
            }
        }
        DFS2(root, arr);
    }

    private void DFS(TreeNode root) {
        if (root == null) {
            return;
        }
        DFS(root.left);
        list.add(root.val);
        list2.add(root.val);
        DFS((root.right));
    }

    private void DFS2(TreeNode root, int[] arr) {
        if (root == null) {
            return;
        }
        if (isChanged[0] && isChanged[1]) {
            return;
        }
        DFS2(root.left, arr);
        if (root.val == arr[0] && !isChanged[0]) {
            root.val = arr[1];
            isChanged[0] = true;
        }
        if (root.val == arr[1] && !isChanged[1]) {
            root.val = arr[0];
            isChanged[1] = true;
        }
        DFS2(root.right, arr);
    }

    /*  空间复杂度O（1）*/

    TreeNode f = null, upper = null, lower = null;
    boolean[] isFind = {false, false};

    public void recoverTree2(TreeNode root) {
        if (root == null) {
            return;
        }
        DFS3(root);
        int tem = upper.val;
        upper.val = lower.val;
        lower.val = tem;
    }

    private void DFS3(TreeNode root) {
        if (root == null) {
            return;
        }
        if (isFind[0] && isFind[1]) {
            return;
        }
        DFS3(root.left);
        if (f != null) {
            if (f.val > root.val) {
                if (upper == null) {
                    upper = f;
                    lower = root;
                    isFind[0] = true;
                } else {
                    lower = root;
                    isFind[1] = true;
                    return;
                }
            }
        }
        f = root;
        DFS3(root.right);
    }

}

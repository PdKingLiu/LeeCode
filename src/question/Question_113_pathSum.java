package question;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/8/31 11:51
 */
public class Question_113_pathSum {

    /*给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

        说明: 叶子节点是指没有子节点的节点。

        示例:
        给定如下二叉树，以及目标和 sum = 22，

                      5
                     / \
                    4   8
                   /   / \
                  11  13  4
                 /  \    / \
                7    2  5   1
        返回:

        [
           [5,4,11,2],
           [5,8,4,5]
        ] */

    List<List<Integer>> lists = new ArrayList<>(1000);
    List<Integer> tem = new ArrayList<>(1000);
    int add = 0;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        find(root, sum);
        return lists;
    }


    public void find(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        add += root.val;
        tem.add(root.val);
        if (root.right == null && root.left == null) {
            if (add == sum) {
                lists.add(new ArrayList<>(tem));
                tem.remove(tem.size() - 1);
                add -= root.val;
            } else {
                add -= root.val;
                tem.remove(tem.size() - 1);
            }
            return;
        }
        find(root.left, sum);
        find(root.right, sum);
        tem.remove(tem.size() - 1);
        add -= root.val;
    }
}

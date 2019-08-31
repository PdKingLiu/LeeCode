package question;

import common.TreeNode;

/**
 * @author liupeidong
 * Created on 2019/8/30 22:52
 */
public class Question_108_sortedArrayToBST {

    /*将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

        本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

        示例:

        给定有序数组: [-10,-3,0,5,9],

        一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

              0
             / \
           -3   9
           /   /
         -10  5 */

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        } else if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        return create(nums, 0, nums.length);
    }

    private TreeNode create(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }
        int middle = (start + end) >>> 1;
        TreeNode treeNode = new TreeNode(nums[middle]);
        treeNode.left = create(nums, start, middle);
        treeNode.right = create(nums, middle + 1, end);
        return treeNode;
    }
}

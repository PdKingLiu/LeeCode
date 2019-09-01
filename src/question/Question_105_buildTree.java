package question;

import common.TreeNode;

/**
 * @author liupeidong
 * Created on 2019/9/1 9:42
 */
public class Question_105_buildTree {

    /*根据一棵树的前序遍历与中序遍历构造二叉树。

        注意:
        你可以假设树中没有重复的元素。

        例如，给出

        前序遍历 preorder = [3,9,20,15,7]
        中序遍历 inorder = [9,3,15,20,7]
        返回如下的二叉树：

            3
           / \
          9  20
            /  \
           15   7 */

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int index = getIndex(inorder, preorder[0], 0, inorder.length - 1);
        TreeNode root = new TreeNode(preorder[0]);
        root.left = create(preorder, inorder, 1, index + 1, 0, index);
        root.right = create(preorder, inorder, index + 1, preorder.length, index + 1, inorder.length);
        return root;
    }

    private TreeNode create(int[] preorder, int[] inorder, int pstart, int pend, int istart, int iend) {
        if (pstart == pend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pstart]);
        int index = getIndex(inorder, preorder[pstart], istart, iend - 1);
        root.left = create(preorder, inorder, pstart + 1, pstart + 1 + index - istart, istart, index);
        root.right = create(preorder, inorder, pstart + 1 + index - istart, pend, index + 1, iend);
        return root;
    }

    public int getIndex(int[] nums, int n, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (nums[i] == n) {
                return i;
            }
        }
        return -1;
    }
}

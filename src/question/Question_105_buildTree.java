package question;

import common.TreeNode;

import java.util.HashMap;

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

    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        setIndex(inorder);
        TreeNode root = new TreeNode(-1);
        root.right = create(preorder, inorder, 0, preorder.length, 0, inorder.length);
        return root.right;
    }

    private TreeNode create(int[] preorder, int[] inorder, int pstart, int pend, int istart, int iend) {
        if (pstart == pend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pstart]);
        int index = map.get(preorder[pstart]);
        root.left = create(preorder, inorder, pstart + 1, pstart + 1 + index - istart, istart, index);
        root.right = create(preorder, inorder, pstart + 1 + index - istart, pend, index + 1, iend);
        return root;
    }

    private void setIndex(int[] inorder) {
        map = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
    }

}

package question;

import common.TreeNode;

import java.util.HashMap;

/**
 * @author liupeidong
 * Created on 2019/9/1 16:50
 */
public class Question_106_buildTree {

    /*根据一棵树的中序遍历与后序遍历构造二叉树。

        注意:
        你可以假设树中没有重复的元素。

        例如，给出

        中序遍历 inorder = [9,3,15,20,7]
        后序遍历 postorder = [9,15,7,20,3]
        返回如下的二叉树：

            3
           / \
          9  20
            /  \
           15   7 */

    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        setIndex(inorder);
        TreeNode treeNode = new TreeNode(-1);
        treeNode.right = create(inorder, postorder, 0, inorder.length, 0, postorder.length);
        return treeNode.right;
    }

    private void setIndex(int[] inorder) {
        map = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
    }

    public TreeNode create(int[] inorder, int[] postorder, int istart, int iend, int pstart, int pend) {
        if (pstart == pend) {
            return null;
        }
        int index = map.get(postorder[pend - 1]);
        TreeNode root = new TreeNode(postorder[pend - 1]);
        root.left = create(inorder, postorder, istart, index, pstart, pstart + index - istart);
        root.right = create(inorder, postorder, index + 1, iend, pstart + index - istart, pend - 1);
        return root;
    }
}

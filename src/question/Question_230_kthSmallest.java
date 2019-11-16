package question;

import common.TreeNode;

/**
 * @author liupeidong
 * Created on 2019/11/16 22:01
 */
public class Question_230_kthSmallest {



    /*给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。

        说明：
        你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。

        示例 1:

        输入: root = [3,1,4,null,2], k = 1
           3
          / \
         1   4
          \
           2
        输出: 1
        示例 2:

        输入: root = [5,3,6,2,4,null,null,1], k = 3
               5
              / \
             3   6
            / \
           2   4
          /
         1
        输出: 3  */

    int index = 0;
    boolean isFind = false;
    int target = 0;

    public int kthSmallest(TreeNode root, int k) {
        if(root == null || isFind) {
            return target;
        }
        kthSmallest(root.left,k);
        index++;
        if(index == k){
            target = root.val;
        }
        kthSmallest(root.right,k);
        return target;
    }


}

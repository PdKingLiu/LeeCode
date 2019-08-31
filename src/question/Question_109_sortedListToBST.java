package question;

import common.ListNode;
import common.TreeNode;

import java.util.ArrayList;

/**
 * @author liupeidong
 * Created on 2019/8/31 10:42
 */
public class Question_109_sortedListToBST {

    /*给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。

        本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

        示例:

        给定的有序链表： [-10, -3, 0, 5, 9],

        一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：

              0
             / \
           -3   9
           /   /
         -10  5 */

    ArrayList<Integer> arrayList = new ArrayList<>(2000);

    public TreeNode sortedListToBST(ListNode head) {
        while (head != null) {
            arrayList.add(head.val);
            head = head.next;
        }
        return create(arrayList, 0, arrayList.size());
    }

    private TreeNode create(ArrayList<Integer> arrayList, int start, int end) {
        if (start >= end) {
            return null;
        }
        int middle = (start + end) >>> 1;
        TreeNode treeNode = new TreeNode(arrayList.get(middle));
        treeNode.left = create(arrayList, start, middle);
        treeNode.right = create(arrayList, middle + 1, end);
        return treeNode;
    }
}

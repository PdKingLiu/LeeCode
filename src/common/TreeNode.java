package common;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liupeidong
 * Created on 2019/8/23 11:32
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(Integer[] values) {
        this.val = values[0];
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this);
        int count = 1;
        while (count < values.length) {
            TreeNode treeNode;
            for (int i = 0; i < queue.size(); i++) {
                treeNode = queue.poll();
                if (values[count] != null) {
                    treeNode.left = new TreeNode(values[count++]);
                    queue.add(treeNode.left);
                }else{
                    count++;
                }
                if (count == values.length) {
                    break;
                }
                if (values[count] != null) {
                    treeNode.right = new TreeNode(values[count++]);
                    queue.add(treeNode.right);
                }else{
                    count++;
                }
                if (count == values.length) {
                    break;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

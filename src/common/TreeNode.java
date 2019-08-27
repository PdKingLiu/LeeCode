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
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                treeNode = queue.peek();
                if (treeNode == null) {
                    queue.add(null);
                    queue.add(null);
                    count += 2;
                    queue.poll();
                    if (count >= values.length) {
                        break;
                    } else {
                        continue;
                    }
                }
                queue.poll();
                if (values[count] != null) {
                    treeNode.left = new TreeNode(values[count++]);
                    queue.add(treeNode.left);
                } else {
                    queue.add(null);
                    count++;
                }
                if (count == values.length) {
                    break;
                }
                if (values[count] != null) {
                    treeNode.right = new TreeNode(values[count++]);
                    queue.add(treeNode.right);
                } else {
                    queue.add(null);
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
        return "{" +
                "val=" + val +
                ", l=" + left +
                ", r=" + right +
                '}';
    }
}

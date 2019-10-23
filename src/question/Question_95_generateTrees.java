package question;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/10/23 10:32
 */
public class Question_95_generateTrees {

    /*给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。

        示例:

        输入: 3
        输出:
        [
          [1,null,3,2],
          [3,2,null,1],
          [3,1,null,null,2],
          [2,1,3],
          [1,null,2,null,3]
        ]
        解释:
        以上的输出对应以下 5 种不同结构的二叉搜索树：

           1         3     3      2      1
            \       /     /      / \      \
             3     2     1      1   3      2
            /     /       \                 \
           2     1         2                 3 */

    /*
    * 递归解决
    * 每次递归完后将左右两个分支合并返回
    * */


    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        } else if (n == 1) {
            ArrayList<TreeNode> arrayList = new ArrayList<>();
            arrayList.add(new TreeNode(1));
            return arrayList;
        } else {
            return createTrees(1, n);
        }
    }

    private List<TreeNode> createTrees(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();
        if (start > end) {
            trees.add(null);
            return trees;
        }
        List<TreeNode> leftTrees;
        List<TreeNode> rightTrees;
        for (int i = start; i <= end; i++) {
            leftTrees = createTrees(start, i - 1);
            rightTrees = createTrees(i + 1, end);
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = leftTree;
                    treeNode.right = rightTree;
                    trees.add(treeNode);
                }
            }
        }
        return trees;
    }

}

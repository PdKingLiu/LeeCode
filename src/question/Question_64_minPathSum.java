package question;

/**
 * @author liupeidong
 * Created on 2019/8/10 9:28
 */
public class Question_64_minPathSum {

    /*给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

        说明：每次只能向下或者向右移动一步。

        示例:

        输入:
        [
          [1,3,1],
          [1,5,1],
          [4,2,1]
        ]
        输出: 7
        解释: 因为路径 1→3→1→1→1 的总和最小。 */

    public int minPathSum(int[][] grid) {
        int[][] indexSum = new int[grid.length][grid[0].length];
        indexSum[0][0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            indexSum[0][i] = grid[0][i] + indexSum[0][i - 1];
        }
        for (int i = 1; i < grid.length; i++) {
            indexSum[i][0] = grid[i][0] + indexSum[i - 1][0];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                indexSum[i][j] = Math.min(indexSum[i][j - 1], indexSum[i - 1][j]) + grid[i][j];
            }
        }
        return indexSum[indexSum.length - 1][indexSum[0].length - 1];
    }
}

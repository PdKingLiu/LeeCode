package question;

import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/9/2 20:53
 */
public class Question_120_minimumTotal {

    /*给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

        例如，给定三角形：

        [
             [2],
            [3,4],
           [6,5,7],
          [4,1,8,3]
        ]
        自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

        说明：

        如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 */

    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size() + 1][triangle.get(triangle.size() - 1).size() + 1];
        dp[1][1] = triangle.get(0).get(0);
        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = triangle.get(i - 1).get(j - 1);
                if (j == 1) {
                    dp[i][j] += dp[i - 1][j];
                } else if (j == i) {
                    dp[i][j] += dp[i - 1][j - 1];
                } else {
                    dp[i][j] += Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < dp[dp.length - 1].length; i++) {
            if (dp[dp.length - 1][i] < min) {
                min = dp[dp.length - 1][i];
            }
        }
        return min;
    }
}

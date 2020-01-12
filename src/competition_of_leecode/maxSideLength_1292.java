package competition_of_leecode;

/**
 * @author liupeidong
 * Created on 2020/1/13 0:04
 */
public class maxSideLength_1292 {

    /*给你一个大小为 m x n 的矩阵 mat 和一个整数阈值 threshold。

        请你返回元素总和小于或等于阈值的正方形区域的最大边长；如果没有这样的正方形区域，则返回 0 。

        示例 1：

        输入：mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = 4
        输出：2
        解释：总和小于 4 的正方形的最大边长为 2，如图所示。
        示例 2：

        输入：mat = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]], threshold = 1
        输出：0
        示例 3：

        输入：mat = [[1,1,1,1],[1,0,0,0],[1,0,0,0],[1,0,0,0]], threshold = 6
        输出：3
        示例 4：

        输入：mat = [[18,70],[61,1],[25,85],[14,40],[11,96],[97,96],[63,45]], threshold = 40184
        输出：2

        提示：

        1 <= m, n <= 300
        m == mat.length
        n == mat[i].length
        0 <= mat[i][j] <= 10000
        0 <= threshold <= 10^5 */


    /*
    * 超时
    * */

    public int maxSideLength(int[][] mat, int threshold) {
        if (mat.length == 0) {
            return 0;
        }
        int[][] arrHeng = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                arrHeng[i][j] += mat[i][j];
                if (j != 0) {
                    arrHeng[i][j] += arrHeng[i][j - 1];
                }
            }
        }
        int max = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int maxLen = Math.min(mat[0].length - j, mat.length - i);
                for (int k = 0; k < maxLen; k++) {
                    if (k != 0) {
                        int sumTem = 0;
                        for (int l = 0; l <= k; l++) {
                            sumTem += arrHeng[i + l][j + k] - arrHeng[i + l][j] + mat[i + l][j];
                        }
                        if (sumTem <= threshold) {
                            max = Math.max(max, k + 1);
                        }
                    }
                }
            }
        }
        return max;
    }

}

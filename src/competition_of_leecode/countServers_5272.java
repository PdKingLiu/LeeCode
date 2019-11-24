package competition_of_leecode;

/**
 * @author liupeidong
 * Created on 2019/11/24 14:36
 */
public class countServers_5272 {

    /*5272. 统计参与通信的服务器 显示英文描述

        用户通过次数844
        用户尝试次数933
        通过次数859
        提交次数1464
        题目难度Medium

        这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。

        如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。

        请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。

        示例 1：

        输入：grid = [[1,0],[0,1]]
        输出：0
        解释：没有一台服务器能与其他服务器进行通信。
        示例 2：

        输入：grid = [[1,0],[1,1]]
        输出：3
        解释：所有这些服务器都至少可以与一台别的服务器进行通信。
        示例 3：

        输入：grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
        输出：4
        解释：第一行的两台服务器互相通信，第三列的两台服务器互相通信，但右下角的服务器无法与其他服务器通信。

        提示：

        m == grid.length
        n == grid[i].length
        1 <= m <= 250
        1 <= n <= 250
        grid[i][j] == 0 or 1*/

    private int countServers(int[][] grid) {
        if (grid == null || grid.length == 0 || (grid.length == 1 && grid[0].length == 1)) {
            return 0;
        }
        boolean[] isVisiti = new boolean[grid.length];
        boolean[] isVisitj = new boolean[grid[0].length];
        int[] visiti = new int[grid.length];
        int[] visitj = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    if (!isVisiti[i]) {
                        int ok = 0;
                        for (int k = 0; k < grid[i].length; k++) {
                            if (grid[i][k] == 1) {
                                ok++;
                            }
                        }
                        if (ok > 1) {
                            visiti[i] = 1;
                        }
                        isVisiti[i] = true;
                    }
                    if (!isVisitj[j]) {
                        int ok = 0;
                        for (int[] ints : grid) {
                            if (ints[j] == 1) {
                                ok++;
                            }
                        }
                        if (ok > 1) {
                            visitj[j] = 1;
                        }
                        isVisitj[j] = true;
                    }
                    if (visiti[i] == 0 && visitj[j] == 0) {
                        grid[i][j] = 0;
                    }
                }
            }
        }
        int sum = 0;
        for (int[] ints : grid) {
            for (int anInt : ints) {
                if (anInt == 1) {
                    sum++;
                }
            }
        }
        return sum;
    }

}

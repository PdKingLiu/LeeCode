package competition_of_leecode;

/**
 * @author liupeidong
 * Created on 2019/11/17 14:31
 */
public class minPushBox_5266 {

    /*「推箱子」是一款风靡全球的益智小游戏，玩家需要将箱子推到仓库中的目标位置。

        游戏地图用大小为 n * m 的网格 grid 表示，其中每个元素可以是墙、地板或者是箱子。

        现在你将作为玩家参与游戏，按规则将箱子 'B' 移动到目标位置 'T' ：

        玩家用字符 'S' 表示，只要他在地板上，就可以在网格中向上、下、左、右四个方向移动。
        地板用字符 '.' 表示，意味着可以自由行走。
        墙用字符 '#' 表示，意味着障碍物，不能通行。 
        箱子仅有一个，用字符 'B' 表示。相应地，网格上有一个目标位置 'T'。
        玩家需要站在箱子旁边，然后沿着箱子的方向进行移动，此时箱子会被移动到相邻的地板单元格。记作一次「推动」。
        玩家无法越过箱子。
        返回将箱子推到目标位置的最小 推动 次数，如果无法做到，请返回 -1。

        示例 1：

        输入：grid = [["#","#","#","#","#","#"],
                     ["#","T","#","#","#","#"],
                     ["#",".",".","B",".","#"],
                     ["#",".","#","#",".","#"],
                     ["#",".",".",".","S","#"],
                     ["#","#","#","#","#","#"]]
        输出：3
        解释：我们只需要返回推箱子的次数。 */

    int[] T = new int[2];
    int[] B = new int[2];
    int[] S = new int[2];

    public int minPushBox(char[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'T') {
                    T[0] = i;
                    T[1] = j;
                } else if (grid[i][j] == 'B') {
                    B[0] = i;
                    B[1] = j;
                } else if (grid[i][j] == 'S') {
                    S[0] = i;
                    S[1] = j;
                }
            }
        }
        boolean[][] isVisit = new boolean[grid.length][grid[0].length];
        DFS(B[0], B[1], S[0], S[1], isVisit, grid);
        return min;
    }

    int tem = 0;
    int min = Integer.MAX_VALUE;

    private void DFS(int bi, int bj, int si, int sj, boolean[][] isVisit, char[][] grid) {
        if (bi < 0 || bi >= grid.length
                || bj < 0 || bj >= grid[0].length
                || grid[bi][bj] == '.'
                || isVisit[bi][bj]) {
            return;
        }
        if (bi == T[0] && bj == T[1]) {
            min = Math.min(tem, min);
            return;
        }
        isVisit[bi][bj] = true;
        if (canGo(bi, bj, bi + 1, bj, si, sj, grid, new boolean[grid.length][grid[0].length])) {
            tem++;
            DFS(bi - 1, bj, bi, bj, isVisit, grid);
            tem--;
        }
        if (canGo(bi, bj, bi - 1, bj, si, sj, grid, new boolean[grid.length][grid[0].length])) {
            tem++;
            DFS(bi + 1, bj, bi, bj, isVisit, grid);
            tem--;
        }
        if (canGo(bi, bj, bi, bj + 1, si, sj, grid, new boolean[grid.length][grid[0].length])) {
            tem++;
            DFS(bi, bj - 1, bi, bj, isVisit, grid);
            tem--;
        }
        if (canGo(bi, bj, bi, bj - 1, si, sj, grid, new boolean[grid.length][grid[0].length])) {
            tem++;
            DFS(bi, bj + 1, bi, bj, isVisit, grid);
            tem--;
        }
        isVisit[bi][bj] = false;
    }

    private boolean canGo(int bi, int bj, int ti, int tj, int si, int sj, char[][] grid, boolean[][] isVisit) {
        if (si < 0 || si >= grid.length
                || sj < 0 || sj >= grid[0].length
                || (grid[si][sj] == '.' || (si == bi && sj == bj))
                || isVisit[si][sj]) {
            return false;
        }
        isVisit[si][sj] = true;
        if (ti == si && tj == sj) {
            return true;
        }
        boolean end = canGo(bi, bj, ti, tj, si - 1, sj, grid, isVisit)
                || canGo(bi, bj, ti, tj, si - 1, sj, grid, isVisit)
                || canGo(bi, bj, ti, tj, si - 1, sj, grid, isVisit)
                || canGo(bi, bj, ti, tj, si - 1, sj, grid, isVisit);
        isVisit[si][sj] = false;
        return end;
    }

}

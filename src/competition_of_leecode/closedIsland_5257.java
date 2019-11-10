package competition_of_leecode;

import java.util.*;

/**
 * @author liupeidong
 * Created on 2019/11/10 14:40
 */
public class closedIsland_5257 {

    /*5257. 统计封闭岛屿的数目 显示英文描述

        用户通过次数436
        用户尝试次数513
        通过次数440
        提交次数793
        题目难度Medium

        有一个二维矩阵 grid ，每个位置要么是陆地（记号为 0 ）要么是水域（记号为 1 ）。

        我们从一块陆地出发，每次可以往上下左右 4 个方向相邻区域走，能走到的所有陆地区域，我们将其称为一座「岛屿」。

        如果一座岛屿 完全 由水域包围，即陆地边缘上下左右所有相邻区域都是水域，那么我们将其称为 「封闭岛屿」。

        请返回封闭岛屿的数目。

        示例 1：

        输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
        输出：2
        解释：
        灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。
        示例 2：

        输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
        输出：1
        示例 3：

        输入：grid = [[1,1,1,1,1,1,1],
                   [1,0,0,0,0,0,1],
                   [1,0,1,1,1,0,1],
                   [1,0,1,0,1,0,1],
                   [1,0,1,1,1,0,1],
                   [1,0,0,0,0,0,1],
                   [1,1,1,1,1,1,1]]
        输出：2

        提示：

        1 <= grid.length, grid[0].length <= 100
        0 <= grid[i][j] <=1*/

    /*
    * 这个题应该用深搜也可以吧，但是不太好写应该。
    * 我用广搜做的。
    * */

    /*
    * 我的理解是，不封闭，那就意味着，有元素在这个矩阵的边界，事实证明确实如此。所以当我们发现一个区域包含边界点时，那他就是不封闭的。
    * 由是0的点开始广搜，我们可以发现不管是封闭还是不封闭，当开始搜的话，都可以把这一片封闭或者不封闭的区域访问完，所以啊，我们都每次访问的点设置标记。以后对这个点进行BFS的时候，就可以不搜索了。
    * 思路就是这么简单。
    *
    * */

    boolean[][] isVisit;
    boolean isHave = true;

    public int closedIsland(int[][] grid) {
        isVisit = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0 && !isVisit[i][j]) {
                    BFS(i, j, grid);
                    if (isHave) {
                        count++;
                    }
                }
                isHave = true;
            }
        }
        return count;
    }

    private void BFS(int i, int j, int[][] grid) {
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(new ArrayList<>(Arrays.asList(i, j)));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                List<Integer> list = queue.poll();
                int i1 = list.get(0);
                int j1 = list.get(1);
                isVisit[i1][j1] = true;
                if (i1 == 0 || i1 == grid.length - 1 || j1 == 0 || j1 == grid[0].length - 1) {
                    isHave = false;
                }
                if (i1 - 1 >= 0 && grid[i1 - 1][j1] == 0 && !isVisit[i1 - 1][j1]) {
                    queue.add(new ArrayList<>(Arrays.asList(i1 - 1, j1)));
                }
                if (i1 + 1 < grid.length && grid[i1 + 1][j1] == 0 && !isVisit[i1 + 1][j1]) {
                    queue.add(new ArrayList<>(Arrays.asList(i1 + 1, j1)));
                }
                if (j1 - 1 >= 0 && grid[i1][j1 - 1] == 0 && !isVisit[i1][j1 - 1]) {
                    queue.add(new ArrayList<>(Arrays.asList(i1, j1 - 1)));
                }
                if (j1 + 1 < grid[0].length && grid[i1][j1 + 1] == 0 && !isVisit[i1][j1 + 1]) {
                    queue.add(new ArrayList<>(Arrays.asList(i1, j1 + 1)));
                }
            }
        }
    }
}

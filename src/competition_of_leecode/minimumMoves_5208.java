package competition_of_leecode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @author liupeidong
 * Created on 2019/9/29 13:02
 */
public class minimumMoves_5208 {

    /*
    * BFS
    * 稍微有点复杂
    * 蛇能走的方向有6个
    * */

    /*5208. 穿过迷宫的最少移动次数 显示英文描述

        用户通过次数45
        用户尝试次数84
        通过次数48
        提交次数145
        题目难度Hard

        你还记得那条风靡全球的贪吃蛇吗？

        我们在一个 n*n 的网格上构建了新的迷宫地图，蛇的长度为 2，也就是说它会占去两个单元格。蛇会从左上角（(0, 0) 和 (0, 1)）开始移动。我们用 0 表示空单元格，用 1 表示障碍物。蛇需要移动到迷宫的右下角（(n-1, n-2) 和 (n-1, n-1)）。

        每次移动，蛇可以这样走：

        如果没有障碍，则向右移动一个单元格。并仍然保持身体的水平／竖直状态。
        如果没有障碍，则向下移动一个单元格。并仍然保持身体的水平／竖直状态。
        如果它处于水平状态并且其下面的两个单元都是空的，就顺时针旋转 90 度。蛇从（(r, c)、(r, c+1)）移动到 （(r, c)、(r+1, c)）。

        如果它处于竖直状态并且其右面的两个单元都是空的，就逆时针旋转 90 度。蛇从（(r, c)、(r+1, c)）移动到（(r, c)、(r, c+1)）。

        返回蛇抵达目的地所需的最少移动次数。

        如果无法到达目的地，请返回 -1。

        示例 1：

        输入：grid = [[0,0,0,0,0,1],
                       [1,1,0,0,1,0],
                       [0,0,0,0,1,1],
                       [0,0,1,0,1,0],
                       [0,1,1,0,0,0],
                       [0,1,1,0,0,0]]
        输出：11
        解释：
        一种可能的解决方案是 [右, 右, 顺时针旋转, 右, 下, 下, 下, 下, 逆时针旋转, 右, 下]。
        示例 2：

        输入：grid = [[0,0,1,1,1,1],
                       [0,0,0,0,1,1],
                       [1,1,0,0,0,1],
                       [1,1,1,0,0,1],
                       [1,1,1,0,0,1],
                       [1,1,1,0,0,0]]
        输出：9


        提示：

        2 <= n <= 100
        0 <= grid[i][j] <= 1
        蛇保证从空单元格开始出发。*/

    public int minimumMoves(int[][] grid) {
        return bfs(grid);
    }

    private int bfs(int[][] grid) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 0, 1));
        int res = 0;
        HashSet<Point> set = new HashSet<>(grid.length * grid.length);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                if (set.contains(point)) {
                    continue;
                }
                set.add(point);
                if (point.ei == grid.length - 1 && point.i == grid.length - 1 && point.ej == grid[0].length - 2 && point.j == grid[0].length - 1) {
                    return res;
                }
                if (point.ei == point.i && point.j - point.ej == 1) {
                    if (point.j + 1 < grid[0].length && grid[point.i][point.j + 1] == 0) {
                        queue.add(new Point(point.i, point.j, point.i, point.j + 1));
                    }
                    if (point.i + 1 < grid.length && grid[point.i + 1][point.ej] == 0 && grid[point.i + 1][point.j] == 0) {
                        queue.add(new Point(point.ei + 1, point.ej, point.i + 1, point.j));
                        queue.add(new Point(point.ei, point.ej, point.ei + 1, point.ej));
                    }
                }
                if (point.i - point.ei == 1 && point.j == point.ej) {
                    if (point.i + 1 < grid.length && grid[point.i + 1][point.j] == 0) {
                        queue.add(new Point(point.i, point.j, point.i + 1, point.j));
                    }
                    if (point.j + 1 < grid[0].length && grid[point.ei][point.ej + 1] == 0 && grid[point.i][point.ej + 1] == 0) {
                        queue.add(new Point(point.ei, point.ej + 1, point.i, point.j + 1));
                        queue.add(new Point(point.ei, point.ej, point.ei, point.ej + 1));
                    }
                }

            }
            res++;
        }
        return -1;
    }

    class Point {
        int ei, ej;
        int i, j;

        public Point(int ei, int ej, int i, int j) {
            this.ei = ei;
            this.ej = ej;
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return ei == point.ei &&
                    ej == point.ej &&
                    i == point.i &&
                    j == point.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(ei, ej, i, j);
        }
    }
}

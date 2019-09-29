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

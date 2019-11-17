package competition_of_leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/11/17 14:28
 */
public class shiftGrid_5263 {

    /*给你一个 n 行 m 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。

        每次「迁移」操作将会引发下述活动：

        位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
        位于 grid[i][m - 1] 的元素将会移动到 grid[i + 1][0]。
        位于 grid[n - 1][m - 1] 的元素将会移动到 grid[0][0]。
        请你返回 k 次迁移操作后最终得到的 二维网格。

         

        示例 1：



        输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
        输出：[[9,1,2],[3,4,5],[6,7,8]] */

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < grid[0].length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < grid.length; j++) {
                list.add(grid[j][i]);
            }
            lists.add(list);
        }
        if (k == 0) {
            return lists;
        }
        for (int i = 0; i < k; i++) {
            List<Integer> list = lists.remove(lists.size() - 1);
            Integer m = list.remove(list.size() - 1);
            list.add(0, m);
            lists.add(0, list);
        }
        List<List<Integer>> lists2 = new ArrayList<>();
        for (int i = 0; i < lists.get(0).size(); i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < lists.size(); j++) {
                list.add(lists.get(j).get(i));
            }
            lists2.add(list);
        }
        return lists2;
    }
}

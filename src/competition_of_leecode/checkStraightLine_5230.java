package competition_of_leecode;

/**
 * @author liupeidong
 * Created on 2019/10/20 12:08
 */
public class checkStraightLine_5230 {

    /*5230. 缀点成线 显示英文描述

        用户通过次数970
        用户尝试次数1051
        通过次数986
        提交次数2363
        题目难度Easy

        在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。

        请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 <font color="#c7254e" face="Menlo, Monaco, Consolas, Courier New, monospace">true</font>，否则请返回 <font color="#c7254e" face="Menlo, Monaco, Consolas, Courier New, monospace">false</font>。

        示例 1：

        输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
        输出：true
        示例 2：

        输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
        输出：false

        提示：

        2 <= coordinates.length <= 1000
        coordinates[i].length == 2
        -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
        coordinates 中不含重复的点*/

    public boolean checkStraightLine(int[][] coordinates) {
        double k = ((coordinates[0][1] - coordinates[1][1]) * (1.0d)) / (coordinates[0][0] - coordinates[1][0]);
        double b = coordinates[0][1] - coordinates[0][0] * k;
        for (int[] coordinate : coordinates) {
            if (coordinate[1] != k * coordinate[0] + b) {
                return false;
            }
        }
        return true;
    }
}

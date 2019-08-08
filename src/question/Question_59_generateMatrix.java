package question;

/**
 * @author liupeidong
 * Created on 2019/8/8 15:32
 */
public class Question_59_generateMatrix {

    /*给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

        示例:

        输入: 3
        输出:
        [
         [ 1, 2, 3 ],
         [ 8, 9, 4 ],
         [ 7, 6, 5 ]
        ] */

    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int count = 0, i;
        int starti = 0, startj = 0;
        int endi = n - 1, endj = n - 1;
        while (count != n * n) {
            i = startj;
            while (i <= endj) {
                arr[starti][i] = ++count;
                i++;
            }
            i = starti + 1;
            while (i <= endi) {
                arr[i][endj] = ++count;
                i++;
            }
            i = endj - 1;
            while (i >= startj && starti != endi && i >= 0) {
                arr[endi][i] = ++count;
                i--;
            }
            i = endi - 1;
            while (i > starti && startj != endj && i >= 0) {
                arr[i][startj] = ++count;
                i--;
            }
            starti++;
            startj++;
            endi--;
            endj--;
        }
        return arr;
    }
}

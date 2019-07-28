package question;

/**
 * @author liupeidong
 * Created on 2019/7/27 12:06
 */
public class Question_48_rotate {

/*  给定一个 n × n 的二维矩阵表示一个图像。

    将图像顺时针旋转 90 度。

    说明：

    你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

    示例 1:

    给定 matrix =
        [[1,2,3],
        [4,5,6],
        [7,8,9]]

    原地旋转输入矩阵，使其变为:
        [[7,4,1],
        [8,5,2],
        [9,6,3]]    */

    public void rotate(int[][] matrix) {
        int c = (matrix[0].length + 1) >>> 1;
        int sI = 0, sJ = 0;
        int eI = matrix[0].length - 1, eJ = matrix[0].length - 1;
        while (c-- != 0) {
            if (c == 0 && sI == eI) {
                break;
            }
            int index = eI - sI;
            while (index-- != 0) {
                int tem;
                int before = matrix[sI][sJ];
                int times = eI - sI;
                for (int i = 0; i < times; i++) {
                    tem = matrix[sI][sJ + i + 1];
                    matrix[sI][sJ + i + 1] = before;
                    before = tem;
                }
                for (int i = 0; i < times; i++) {
                    tem = matrix[sI + i + 1][eJ];
                    matrix[sI + i + 1][eJ] = before;
                    before = tem;
                }
                for (int i = 0; i < times; i++) {
                    tem = matrix[eI][eJ - i - 1];
                    matrix[eI][eJ - i - 1] = before;
                    before = tem;
                }
                for (int i = 0; i < times; i++) {
                    tem = matrix[eI - i - 1][sJ];
                    matrix[eI - i - 1][sJ] = before;
                    before = tem;
                }
            }
            ++sI;
            ++sJ;
            --eI;
            --eJ;
        }
    }

}

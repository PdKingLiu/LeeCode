package question;

/**
 * @author liupeidong
 * Created on 2019/8/14 8:49
 */
public class Question_74_searchMatrix {

    /*编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

        每行中的整数从左到右按升序排列。
        每行的第一个整数大于前一行的最后一个整数。
        示例 1:

        输入:
        matrix = [
          [1,   3,  5,  7],
          [10, 11, 16, 20],
          [23, 30, 34, 50]
        ]
        target = 3
        输出: true */

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int left = 0, right = matrix.length * matrix[0].length - 1, middle;
        int temMiddle;
        while (left <= right) {
            middle = (left + right) >> 1;
            temMiddle = matrix[middle / matrix[0].length][middle % matrix[0].length];
            if (temMiddle == target) {
                return true;
            } else if (temMiddle < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return false;
    }
}

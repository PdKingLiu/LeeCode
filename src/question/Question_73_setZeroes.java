package question;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/8/14 10:09
 */
public class Question_73_setZeroes {

    /*给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。

        示例 1:

        输入:
        [
          [1,1,1],
          [1,0,1],
          [1,1,1]
        ]
        输出:
        [
          [1,0,1],
          [0,0,0],
          [1,0,1]
        ] */

    boolean[] isUsedJ;
    boolean[] isUsedI;

    public void setZeroes(int[][] matrix) {
        isUsedJ = new boolean[matrix[0].length];
        isUsedI = new boolean[matrix.length];
        List<List<Integer>> lists = new ArrayList<>(matrix.length);
        for (int[] ints : matrix) {
            List<Integer> list = new ArrayList<>(matrix[0].length);
            for (int j = 0; j < matrix[0].length; j++) {
                if (ints[j] == 0) {
                    list.add(j);
                }
            }
            lists.add(list);
        }
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            for (Integer integer : list) {
                change(matrix, i, integer);
            }
        }
    }

    public void change(int[][] matrix, int i, int j) {
        if (!isUsedI[i]) {
            for (int k = 0; k < matrix[0].length; k++) {
                matrix[i][k] = 0;
            }
            isUsedI[i] = true;
        }
        if (!isUsedJ[j]) {
            for (int k = 0; k < matrix.length; k++) {
                matrix[k][j] = 0;
            }
            isUsedJ[j] = true;
        }
    }
}

package question;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/8/8 11:22
 */
public class Question_54_spiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        int count = matrix.length * matrix[0].length;
        int starti = 0, startj = 0;
        int endi = matrix.length - 1, endj = matrix[0].length - 1;
        int i;
        List<Integer> list = new ArrayList<>();
        while (list.size() != count) {
            i = startj;
            while (i <= endj) {
                list.add(matrix[starti][i]);
                i++;
            }
            i = starti + 1;
            while (i <= endi) {
                list.add(matrix[i][endj]);
                i++;
            }
            i = endj - 1;
            while (i >= startj && starti != endi && i >= 0) {
                list.add(matrix[endi][i]);
                i--;
            }
            i = endi - 1;
            while (i > starti && startj != endj && i >= 0) {
                list.add(matrix[i][startj]);
                i--;
            }
            starti++;
            startj++;
            endi--;
            endj--;
        }
        return list;
    }

}

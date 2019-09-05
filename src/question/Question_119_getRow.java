package question;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/9/5 18:12
 */
public class Question_119_getRow {

    /*给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。

        在杨辉三角中，每个数是它左上方和右上方的数的和。

        示例:

        输入: 3
        输出: [1,3,3,1]
        进阶：

        你可以优化你的算法到 O(k) 空间复杂度吗？ */

    /* 空间复杂度O（k）*/

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) {
            return new ArrayList<>();
        }
        rowIndex++;
        List<Integer> list = new ArrayList<>(rowIndex);
        list.add(1);
        int tem = 1;
        int tem2;
        for (int i = 2; i <= rowIndex; i++) {
            for (int j = 0; j < i; j++) {
                if (j == i - 1) {
                    list.add(1);
                } else if (j != 0) {
                    tem2 = list.get(j);
                    list.set(j, list.get(j) + tem);
                    tem = tem2;
                }
            }
        }
        return list;
    }
}

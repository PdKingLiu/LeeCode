package competition_of_leecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2020/1/13 0:02
 */
public class sequentialDigits_1291 {

    /*我们定义「顺次数」为：每一位上的数字都比前一位上的数字大 1 的整数。

        请你返回由 [low, high] 范围内所有顺次数组成的 有序 列表（从小到大排序）。

        示例 1：

        输出：low = 100, high = 300
        输出：[123,234]
        示例 2：

        输出：low = 1000, high = 13000
        输出：[1234,2345,3456,4567,5678,6789,12345]

        提示：

        10 <= low <= high <= 10^9 */

    public List<Integer> sequentialDigits(int low, int high) {
        int first = low;
        while (first >= 10) {
            first = first / 10;
        }
        for (int i = 1; i < 10; i++) {
            tem = i;
            backtrack(low, high);
            tem = 1;
        }
        Collections.sort(list);
        return list;
    }

    int tem = 1;
    List<Integer> list = new ArrayList<>();

    private void backtrack(int low, int high) {
        if (tem % 10 == 9) {
            return;
        }
        tem = tem * 10 + (tem % 10 + 1);
        if (tem > high) {
            return;
        }
        if (tem >= low) {
            list.add(tem);
        }
        if (tem < low || tem < high) {
            backtrack(low, high);
        }
    }
}

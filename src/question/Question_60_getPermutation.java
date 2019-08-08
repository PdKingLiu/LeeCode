package question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/8/8 15:46
 */
public class Question_60_getPermutation {


    /*给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。

        按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：

        "123"
        "132"
        "213"
        "231"
        "312"
        "321"
        给定 n 和 k，返回第 k 个排列。

        说明：

        给定 n 的范围是 [1, 9]。
        给定 k 的范围是[1,  n!]。
        示例 1:

        输入: n = 3, k = 3
        输出: "213" */

    /*回溯超时*/

    List<String> list = new LinkedList<>();
    StringBuilder stringBuilder = new StringBuilder();
    boolean[] isUsed;
    boolean isFind = false;

    public String getPermutation(int n, int k) {
        isUsed = new boolean[n];
        backtrack(0, n, k);
        return list.get(k - 1);
    }

    private void backtrack(int i, int n, int k) {
        if (isFind) {
            return;
        }
        if (i == n) {
            list.add(stringBuilder.toString());
            if (list.size() == k) {
                isFind = true;
            }
            return;
        }
        for (int j = 0; j < n; j++) {
            if (!isUsed[j] && !isFind) {
                isUsed[j] = true;
                stringBuilder.append((j + 1));
                backtrack(i + 1, n, k);
                stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
                isUsed[j] = false;
            }
        }
    }

}

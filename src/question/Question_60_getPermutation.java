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


    /*线性遍历*/

    List<String> list = new LinkedList<>();
    StringBuilder stringBuilder = new StringBuilder();


    /*回溯超时*/
    boolean[] isUsed;
    boolean isFind = false;

    public String getPermutation2(int n, int k) {
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        int[] J = new int[n + 1];
        getJ(J, n);
        for (int i = 0; k > 0; i++) {
            if (k == 1) {
                for (Integer in : list) {
                    stringBuilder.append(in);
                }
                break;
            }
            int a = k / J[n - i - 1];
            if (a == 0) {
                stringBuilder.append(list.get(0));
                list.remove(0);
            } else if (J[n - i - 1] * a == k) {
                stringBuilder.append(list.get(a - 1));
                list.remove(a - 1);
                if (a > 1) {
                    k = k - (a - 1) * J[n - i - 1];
                }
            } else {
                stringBuilder.append(list.get(a));
                list.remove(a);
                k = k - J[n - i - 1] * a;
            }
        }
        return stringBuilder.toString();
    }

    private void getJ(int[] j, int n) {
        j[0] = 0;
        j[1] = 1;
        for (int i = 2; i <= n; i++) {
            j[i] = j[i - 1] * i;
        }
    }

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

package question;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/8/21 10:20
 */
public class Question_89_grayCode {

    /*格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。

        给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。

        示例 1:

        输入: 2
        输出: [0,1,3,2]
        解释:
        00 - 0
        01 - 1
        11 - 3
        10 - 2

        对于给定的 n，其格雷编码序列并不唯一。
        例如，[0,2,3,1] 也是一个有效的格雷编码序列。

        00 - 0
        10 - 2
        11 - 3
        01 - 1
        示例 2:

        输入: 0
        输出: [0]
        解释: 我们定义格雷编码序列必须以 0 开头。
             给定编码总位数为 n 的格雷编码序列，其长度为 2n。当 n = 0 时，长度为 20 = 1。
             因此，当 n = 0 时，其格雷编码序列为 [0]。 */

    /* 一个非常骚的位运算 */
    public List<Integer> grayCode2(int n) {
        list = new ArrayList<>(1 << n);
        for (int i = 0; i < 1 << n; i++) {
            list.add(i ^ i >> 1);
        }
        return list;
    }

    /*真是个弟弟 真用回溯做了*/

    List<Integer> list;
    int value = 0;
    boolean isFind = false;

    public List<Integer> grayCode(int n) {
        list = new ArrayList<>((int) Math.pow(2, n));
        if (n == 0) {
            list.add(0);
        } else if (n == 1) {
            list.add(0);
            list.add(1);
        } else {
            list.add(0);
            backtrack(0, n);
        }
        return list;
    }

    private void backtrack(int i, int n) {
        if (isFind) {
            return;
        }
        if (i == (int) Math.pow(2, n + 1)) {
            isFind = true;
            return;
        }
        for (int j = 1; j <= n; j++) {
            int tem = getNext(j, value);
            if (!list.contains(tem)) {
                value = tem;
                list.add(value);
                backtrack(i + 1, n);
            }
        }
    }

    private int getNext(int i, int value) {
        int y = value % (int) Math.pow(2, i - 1);
        value = value >>> (i - 1);
        int k = value % 2;
        if (k == 1) {
            value = value - 1;
            value = value << (i - 1);
            value = value + y;
        } else {
            value = value + 1;
            value = value << (i - 1);
            value = value + y;
        }
        return value;
    }
}

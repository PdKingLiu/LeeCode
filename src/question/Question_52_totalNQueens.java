package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/8/28 18:01
 */
public class Question_52_totalNQueens {

    /*n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

        上图为 8 皇后问题的一种解法。

        给定一个整数 n，返回 n 皇后不同的解决方案的数量。

        示例:

        输入: 4
        输出: 2
        解释: 4 皇后问题存在如下两个不同的解法。
        [
         [".Q..",  // 解法 1
          "...Q",
          "Q...",
          "..Q."],

         ["..Q.",  // 解法 2
          "Q...",
          "...Q",
          ".Q.."]
        ] */

    List<List<String>> lists = new ArrayList<>();
    char[][] indexs;
    boolean[] h;
    boolean[] s;
    boolean[] xxia;
    boolean[] xshang;
    int total = 0;

    public int totalNQueens(int n) {
        indexs = new char[n][n];
        h = new boolean[n];
        s = new boolean[n];
        xxia = new boolean[2 * n - 1];
        xshang = new boolean[2 * n - 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(indexs[i], '.');
        }
        backtrack(0, n);
        return total;
    }

    private void backtrack(int i, int n) {
        if (i == n) {
            total++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if (judge(i, j, n)) {
                indexs[i][j] = 'Q';
                changeFlag(i, j, n, true);
                backtrack(i + 1, n);
                indexs[i][j] = '.';
                changeFlag(i, j, n, false);
            }
        }
    }

    private void changeFlag(int i, int j, int n, boolean b) {
        h[i] = b;
        s[j] = b;
        xshang[i + j] = b;
        if (i >= j) {
            xxia[i - j] = b;
        } else {
            xxia[j - i + n - 1] = b;
        }
    }

    private boolean judge(int i, int j, int n) {
        boolean[] booleans = {false, false, false, false};
        if (!h[i]) {
            booleans[0] = true;
        }
        if (!s[j]) {
            booleans[1] = true;
        }
        if (i >= j) {
            if (!xxia[i - j]) {
                booleans[2] = true;
            }
        } else {
            if (!xxia[j - i + n - 1]) {
                booleans[2] = true;
            }
        }
        if (!xshang[i + j]) {
            booleans[3] = true;
        }
        return booleans[0] && booleans[1] && booleans[2] && booleans[3];
    }
}

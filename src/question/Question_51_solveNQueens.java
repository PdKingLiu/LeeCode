package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/8/28 16:15
 */
public class Question_51_solveNQueens {

    /*n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

        上图为 8 皇后问题的一种解法。

        给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。

        每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

        示例:

        输入: 4
        输出: [
         [".Q..",  // 解法 1
          "...Q",
          "Q...",
          "..Q."],

         ["..Q.",  // 解法 2
          "Q...",
          "...Q",
          ".Q.."]
        ] */

    List<List<String>> lists = new ArrayList<>();
    boolean[] isUsed;
    char[][] indexs;

    public List<List<String>> solveNQueens(int n) {
        isUsed = new boolean[n];
        indexs = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(indexs[i], '.');
        }
        backtrack(0, n);
        return lists;
    }

    private void backtrack(int i, int n) {
        if (i == n) {
            if (isTrue(indexs)) {
                lists.add(result(indexs));
            }
            return;
        }
        for (int j = 0; j < n; j++) {
            if (!isUsed[j]) {
                indexs[i][j] = 'Q';
                isUsed[j] = true;
                backtrack(i + 1, n);
                indexs[i][j] = '.';
                isUsed[j] = false;
            }
        }
    }

    private List<String> result(char[][] indexs) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < indexs.length; i++) {
            String string = String.valueOf(indexs[i]);
            list.add(string);
        }
        return list;
    }

    private boolean isTrue(char[][] indexs) {
        for (int i = 0; i < indexs.length; i++) {
            HashMap<Character, Integer> hashMap = new HashMap<>();
            HashMap<Character, Integer> hashMap2 = new HashMap<>();
            HashMap<Character, Integer> hashMap3 = new HashMap<>();
            HashMap<Character, Integer> hashMap4 = new HashMap<>();
            for (int j = 0; j <= i; j++) {
                if (indexs[i - j][j] == 'Q') {
                    hashMap.put('Q', hashMap.getOrDefault('Q', 0) + 1);
                }
                if (indexs[indexs.length - 1 - i + j][indexs.length - 1 - j] == 'Q') {
                    hashMap2.put('Q', hashMap2.getOrDefault('Q', 0) + 1);
                }
                if (indexs[indexs.length - 1 - i + j][j] == 'Q') {
                    hashMap3.put('Q', hashMap3.getOrDefault('Q', 0) + 1);
                }
                if (indexs[j][indexs.length - 1 - i + j] == 'Q') {
                    hashMap4.put('Q', hashMap4.getOrDefault('Q', 0) + 1);
                }
            }
            if (hashMap.get('Q') != null && hashMap.get('Q') > 1) {
                return false;
            }
            if (hashMap2.get('Q') != null && hashMap2.get('Q') > 1) {
                return false;
            }
            if (hashMap3.get('Q') != null && hashMap3.get('Q') > 1) {
                return false;
            }
            if (hashMap4.get('Q') != null && hashMap4.get('Q') > 1) {
                return false;
            }
        }
        return true;
    }

//    -------------------------------------------------------------------

    /*设置标记*/

    boolean[] h;
    boolean[] s;
    boolean[] xxia;
    boolean[] xshang;

    public List<List<String>> solveNQueens2(int n) {
        indexs = new char[n][n];
        h = new boolean[n];
        s = new boolean[n];
        xxia = new boolean[2 * n - 1];
        xshang = new boolean[2 * n - 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(indexs[i], '.');
        }
        backtrack2(0, n);
        return lists;
    }

    private void backtrack2(int i, int n) {
        if (i == n) {
            lists.add(result(indexs));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (judge(i, j, n)) {
                indexs[i][j] = 'Q';
                changeFlag(i, j, n, true);
                backtrack2(i + 1, n);
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

package question;

/**
 * @author liupeidong
 * Created on 2019/10/1 20:30
 */
public class Question_79_exist {

    /*给定一个二维网格和一个单词，找出该单词是否存在于网格中。

        单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

        示例:

        board =
        [
          ['A','B','C','E'],
          ['S','F','C','S'],
          ['A','D','E','E']
        ]

        给定 word = "ABCCED", 返回 true.
        给定 word = "SEE", 返回 true.
        给定 word = "ABCB", 返回 false. */

    /*
    * 回溯
    * 优化后效率提升数倍
    * 主要优化：每次比较对应长度的char
    * 使用回溯修改isVisit的值，避免重复创建isVisit数组
    * */

    public boolean exist(char[][] board, String word) {
        boolean[][] booleans = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && search(booleans, i, j, word, board, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(boolean[][] isVisit, int i, int j, String word, char[][] board, int len) {
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0 || isVisit[i][j]) {
            return false;
        }
        if (board[i][j] != word.charAt(len)) {
            return false;
        }
        if (len + 1 == word.length()) {
            return true;
        }
        isVisit[i][j] = true;
        boolean result = search(isVisit, i - 1, j, word, board, len + 1)
                || search(isVisit, i, j + 1, word, board, len + 1)
                || search(isVisit, i + 1, j, word, board, len + 1)
                || search(isVisit, i, j - 1, word, board, len + 1);
        isVisit[i][j] = false;
        return result;
    }

}

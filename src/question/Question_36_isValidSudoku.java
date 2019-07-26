package question;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liupeidong
 * Created on 2019/7/26 10:53
 */
public class Question_36_isValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Map<Character, Integer> map1 = new HashMap<>();
            Map<Character, Integer> map2 = new HashMap<>();
            Map<Character, Integer> map3 = new HashMap<>();
            for (int j = 0; j < 9; j++) {
                map1.put(board[i][j], map1.getOrDefault(board[i][j], 0) + 1);
                map2.put(board[j][i], map2.getOrDefault(board[j][i], 0) + 1);
                map3.put(board[(i / 3) * 3 + j / 3][j % 3 + (i % 3) * 3], map3.getOrDefault(board[(i / 3) * 3 + j / 3][j % 3 + (i % 3) * 3], 0) + 1);
                if (board[i][j] != '.' && map1.get(board[i][j]) > 1) {
                    return false;
                }
                if (board[j][i] != '.' && map2.get(board[j][i]) > 1) {
                    return false;
                }
                if (board[(i / 3) * 3 + j / 3][j % 3 + (i % 3) * 3] != '.'
                        && map3.get(board[(i / 3) * 3 + j / 3][j % 3 + (i % 3) * 3]) > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}

package question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liupeidong
 * Created on 2019/8/4 10:20
 */
public class Question_37_solveSudoku {

    List<HashMap<Integer, Boolean>> lists;
    List<Integer[]> list;
    boolean isFind = false;

    public void solveSudoku(char[][] board) {
        lists = new ArrayList<>();
        list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            HashMap<Integer, Boolean> hashMap = new HashMap<>();
            for (int j = 0; j < board.length; j++) {
                hashMap.put(j + 1, false);
            }
            lists.add(hashMap);
        }
        for (int i = 0; i < board.length; i++) {
            HashMap<Integer, Boolean> hashMap = lists.get(i);
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    list.add(new Integer[]{i, j});
                } else {
                    hashMap.remove((board[i][j] - 48));
                }
            }
        }
        backtrack(board, 0, list.size());
    }

    private void backtrack(char[][] board, int i, int size) {
        if (isFind) {
            return;
        }
        if (i == size) {
            if (isValidSudoku(board)) {
                isFind = true;
            }
            return;
        } else {
            if (!isValidSudoku(board)) {
                return;
            }
        }
        Integer[] s = list.get(i);
        int ii = s[0];
        int jj = s[1];
        HashMap<Integer, Boolean> hashMap = lists.get(ii);
        for (Integer integer : hashMap.keySet()) {
            if (!hashMap.get(integer) && !isFind) {
                board[ii][jj] = (char) (integer + 48);
                hashMap.put(integer, true);
                backtrack(board, i + 1, size);
                if (!isFind) {
                    board[ii][jj] = '.';
                    hashMap.put(integer, false);
                }
            }
        }
    }

    public boolean isValidSudoku(char[][] board) {
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

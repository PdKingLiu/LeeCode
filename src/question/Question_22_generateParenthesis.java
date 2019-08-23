package question;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/4/28 17:15
 */
public class Question_22_generateParenthesis {

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public static void backtrack(List<String> list, String str, int i, int i1, int n) {
        if (str.length() == n * 2) {
            list.add(str);
            return;
        }
        if (i < n) {
            backtrack(list, str + "(", i + 1, i1, n);
        }
        if (i1 < i) {
            backtrack(list, str + ")", i, i1 + 1, n);
        }
    }

}

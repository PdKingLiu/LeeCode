package question;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/4/16 21:00
 */
public class Question_17_LetterCombinations {

    static char[][] ch = {{'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}};

    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.equals("")) {
            return list;
        }
        char[] digitChar = digits.toCharArray();
        for (char c : digitChar) {
            char[] c1 = ch[c - 50];
            getStrings(list, c1);
        }
        return list;
    }

    private static void getStrings(List<String> list, char[] chars) {
        List list1 = null;
        if (list == null || list.size() == 0) {
            for (char c : chars) {
                list.add(String.valueOf(c));
            }
            return;
        }
        list1 = new ArrayList();
        for (String string : list) {
            for (char c : chars) {
                list1.add(string + c);
            }
        }
        list.clear();
        list.addAll(list1);
    }
}

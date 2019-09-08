package question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/9/8 10:20
 */
public class Question_131_partition {

    /*给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

        返回 s 所有可能的分割方案。

        示例:

        输入: "aab"
        输出:
        [
          ["aa","b"],
          ["a","a","b"]
        ] */

    List<List<String>> listList;
    List<String> tem;

    public List<List<String>> partition(String s) {
        listList = new LinkedList<>();
        tem = new LinkedList<>();
        if (s == null || s.equals("")) {
            listList.add(tem);
            return listList;
        }
        backtrack(s, 0);
        return listList;
    }

    private void backtrack(String s, int i) {
        if (i == s.length()) {
            listList.add(new ArrayList<>(tem));
        }
        for (int j = i; j < s.length(); j++) {
            String sub = s.substring(i, j + 1);
            if (isHui(sub)) {
                tem.add(sub);
                backtrack(s, j + 1);
                tem.remove(tem.size() - 1);
            }
        }
    }

    private boolean isHui(String substring) {
        return new StringBuffer(substring).reverse().toString().equals(substring);
    }
}

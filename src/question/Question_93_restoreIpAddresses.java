package question;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/10/2 11:46
 */
public class Question_93_restoreIpAddresses {

    /*给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

        示例:

        输入: "25525511135"
        输出: ["255.255.11.135", "255.255.111.35"] */

    /*回溯*/

    public List<String> restoreIpAddresses(String s) {
        return backtrack(0, 0, s, new ArrayList<>(1000), new StringBuffer());
    }

    private List<String> backtrack(int n, int start, String s, ArrayList<String> results, StringBuffer tem) {
        if (n == 4) {
            if (start == s.length()) {
                results.add(tem.substring(0, tem.length() - 1));
            }
            return results;
        }
        for (int i = start; i < start + 3 && i < s.length(); i++) {
            String s1 = s.substring(start, i + 1);
            if (!(i == start + 2 && Integer.parseInt(s1) > 255 || !String.valueOf(Integer.parseInt(s1)).equals(s1))) {
                tem.append(s1).append(".");
                backtrack(n + 1, i + 1, s, results, tem);
                tem.delete(tem.length() - s1.length() - 1, tem.length());
            }
        }
        return results;
    }
}

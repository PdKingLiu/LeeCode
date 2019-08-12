package question;

/**
 * @author liupeidong
 * Created on 2019/8/12 19:11
 */
public class Question_67_addBinary {

    /*给定两个二进制字符串，返回他们的和（用二进制表示）。

        输入为非空字符串且只包含数字 1 和 0。

        示例 1:

        输入: a = "11", b = "1"
        输出: "100"
        示例 2:

        输入: a = "1010", b = "1011"
        输出: "10101" */

    public static String addBinary(String a, String b) {
        StringBuffer stringBufferA = new StringBuffer();
        StringBuffer stringBufferB = new StringBuffer();
        StringBuffer end = new StringBuffer();
        if (a.length() > b.length()) {
            for (int i = 0; i < a.length() - b.length(); i++) {
                stringBufferB.append("0");
            }
        } else if (a.length() < b.length()) {
            for (int i = 0; i < b.length() - a.length(); i++) {
                stringBufferA.append("0");
            }
        }
        stringBufferA.append(a);
        stringBufferB.append(b);
        int j = 0;
        for (int i = stringBufferA.length() - 1; i >= 0; i--) {
            int res = stringBufferA.charAt(i) + stringBufferB.charAt(i);
            if (res == 96) {
                if (j == 1) {
                    end.append("1");
                    j = 0;
                } else {
                    end.append("0");
                }
            } else if (res == 97) {
                if (j == 1) {
                    end.append("0");
                } else {
                    end.append("1");
                }
            } else {
                if (j == 1) {
                    end.append("1");
                } else {
                    end.append("0");
                    j = 1;
                }
            }
        }
        if (j == 1) {
            end.append("1");
        }
        return end.reverse().toString();
    }
}

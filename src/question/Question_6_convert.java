package question;

/**
 * @author liupeidong
 * Created on 2019/8/1 10:35
 */
public class Question_6_convert {

    /*将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

        比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

        L   C   I   R
        E T O E S I I G
        E   D   H   N
        之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

        请你实现这个将字符串进行指定行数变换的函数：

        string convert(string s, int numRows);
        示例 1:

        输入: s = "LEETCODEISHIRING", numRows = 3
        输出: "LCIRETOESIIGEDHN"
        示例 2:

        输入: s = "LEETCODEISHIRING", numRows = 4
        输出: "LDREOEIIECIHNTSG"
        解释:

        L     D     R
        E   O E   I I
        E C   I H   N
        T     S     G*/

    public static String convert(String s, int numRows) {
        if (numRows == 1 || s.length() == 1) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (i == 0 && j % (numRows * 2 - 2) == 0) {
                    stringBuilder.append(s.charAt(j));//第一行
                } else if (numRows != 2 && ((j + i) % (numRows * 2 - 2) == 0 || (j - i) % (numRows * 2 - 2) == 0)) {
                    stringBuilder.append(s.charAt(j));//中间行
                } else if (i == numRows - 1 && (j - numRows + 1) % (numRows * 2 - 2) == 0) {
                    stringBuilder.append(s.charAt(j));//最后一行
                }
            }
        }
        return stringBuilder.toString();
    }

}

package question;

/**
 * @author liupeidong
 * Created on 2019/8/1 9:41
 */
public class Question_38_countAndSay {

    /*报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：

        1.     1
        2.     11
        3.     21
        4.     1211
        5.     111221
        1 被读作  "one 1"  ("一个一") , 即 11。
        11 被读作 "two 1s" ("两个一"）, 即 21。
        21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

        给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。

        注意：整数顺序将表示为一个字符串。

        示例 1:

        输入: 1
        输出: "1"
        示例 2:

        输入: 4
        输出: "1211" */

    public String countAndSay(int n) {
        StringBuilder end = new StringBuilder("1"), tem = new StringBuilder("1");
        for (int i = 0; i < n - 1; i++) {
            end.delete(0, end.length());
            int index = 0;
            while (index < tem.length()) {
                index = getNextIndex(tem, end, index);
            }
            tem.delete(0, tem.length());
            tem.append(end);
        }
        return end.toString();
    }

    private int getNextIndex(StringBuilder tem, StringBuilder end, int index) {
        char c = tem.charAt(index);
        int i;
        for (i = index; i < tem.length(); i++) {
            if (tem.charAt(i) != c) {
                break;
            }
        }
        end.append(i - index).append(c);
        return i;
    }
}

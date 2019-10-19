package competition_of_leecode;

/**
 * @author liupeidong
 * Created on 2019/10/19 15:08
 */
public class balancedStringSplit_1221 {

    /*1221. 分割平衡字符串 显示英文描述
        用户通过次数986
        用户尝试次数1042
        通过次数1002
        提交次数1414
        题目难度Easy
        在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。

        给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。

        返回可以通过分割得到的平衡字符串的最大数量。

        示例 1：

        输入：s = "RLRRLLRLRL"
        输出：4
        解释：s 可以分割为 "RL", "RRLL", "RL", "RL", 每个子字符串中都包含相同数量的 'L' 和 'R'。
        示例 2：

        输入：s = "RLLLLRRRLR"
        输出：3
        解释：s 可以分割为 "RL", "LLLRRR", "LR", 每个子字符串中都包含相同数量的 'L' 和 'R'。
        示例 3：

        输入：s = "LLLLRRRR"
        输出：1
        解释：s 只能保持原样 "LLLLRRRR".

        提示：

        1 <= s.length <= 1000
        s[i] = 'L' 或 'R'*/

    public int balancedStringSplit(String s) {
        int dex = 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                dex++;
            } else {
                dex--;
            }
            if (dex == 0) {
                sum++;
            }
        }
        return sum;
    }

}

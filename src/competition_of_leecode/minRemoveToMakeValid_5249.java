package competition_of_leecode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author liupeidong
 * Created on 2019/11/3 14:12
 */
public class minRemoveToMakeValid_5249 {


    /*5249. 移除无效的括号

        用户通过次数419
        用户尝试次数500
        通过次数425
        提交次数839
        题目难度Medium

        给你一个由 '('、')' 和小写字母组成的字符串 s。

        你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，使得剩下的「括号字符串」有效。

        请返回任意一个合法字符串。

        有效「括号字符串」应当符合以下 任意一条 要求：

        空字符串或只包含小写字母的字符串
        可以被写作 AB（A 连接 B）的字符串，其中 A 和 B 都是有效「括号字符串」
        可以被写作 (A) 的字符串，其中 A 是一个有效的「括号字符串」


        示例 1：

        输入：s = "lee(t(c)o)de)"
        输出："lee(t(c)o)de"
        解释："lee(t(co)de)" , "lee(t(c)ode)" 也是一个可行答案。
        示例 2：

        输入：s = "a)b(c)d"
        输出："ab(c)d"
        示例 3：

        输入：s = "))(("
        输出：""
        解释：空字符串也是有效的
        示例 4：

        输入：s = "(a(b(c)d)"
        输出："a(b(c)d)"


        提示：

        1 <= s.length <= 10^5
        s[i] 可能是 '('、')' 或英文小写字母
*/

    /*用栈写。

        对于(直接入栈

        对于)如果栈是空不做操作

        不是空，那么栈顶的(则是有效的括号，对应的当前的)也是有效的

        最后遍历就好，

        如果是合法的括号就append上、*/

    public String minRemoveToMakeValid(String s) {
        Deque<Integer> stack = new LinkedList<>();
        boolean[] isValid = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    isValid[stack.pop()] = true;
                    isValid[i] = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) == '(' || s.charAt(i) == ')')  ) {
                if (isValid[i]) {
                    sb.append(s.charAt(i));
                }
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }


}

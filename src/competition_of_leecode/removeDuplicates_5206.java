package competition_of_leecode;

/**
 * @author liupeidong
 * Created on 2019/9/29 10:50
 */
public class removeDuplicates_5206 {

    /*
    * 循环处理字符串即可
    * 也可以使用栈
    * */

    /*5206. 删除字符串中的所有相邻重复项 II 显示英文描述

        用户通过次数320
        用户尝试次数393
        通过次数323
        提交次数642
        题目难度Medium

        给你一个字符串 s，「k 倍重复项删除操作」将会从 s 中选择 k 个相邻且相等的字母，并删除它们，使被删去的字符串的左侧和右侧连在一起。

        你需要对 s 重复进行无限次这样的删除操作，直到无法继续为止。

        在执行完所有删除操作后，返回最终得到的字符串。

        本题答案保证唯一。

        示例 1：

        输入：s = "abcd", k = 2
        输出："abcd"
        解释：没有要删除的内容。
        示例 2：

        输入：s = "deeedbbcccbdaa", k = 3
        输出："aa"
        解释：
        先删除 "eee" 和 "ccc"，得到 "ddbbbdaa"
        再删除 "bbb"，得到 "dddaa"
        最后删除 "ddd"，得到 "aa"
        示例 3：

        输入：s = "pbbcggttciiippooaais", k = 2
        输出："ps"*/

    public String removeDuplicates(String s, int k) {
        StringBuffer sb = new StringBuffer(s);
        boolean isContinue = true;
        while (isContinue) {
            int start = 0;
            int len = 1;
            isContinue = false;
            for (int i = 1; i < sb.length(); i++) {
                if (sb.charAt(i) == sb.charAt(i - 1)) {
                    len++;
                    if (len == k) {
                        isContinue = true;
                        sb.replace(start, i + 1, "");
                        i -= len;
                        if (i < 0) {
                            i = 1;
                        }
                    }
                } else {
                    start = i;
                    len = 1;
                }
            }
        }
        return sb.toString();
    }
}

package competition_of_leecode;

import java.util.HashMap;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/10/27 12:45
 */
public class maxLength_5240 {

    /*5240. 串联字符串的最大长度 显示英文描述

        用户通过次数286
        用户尝试次数475
        通过次数293
        提交次数1098
        题目难度Medium

        给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。

        请返回所有可行解 s 中最长长度。

        示例 1：

        输入：arr = ["un","iq","ue"]
        输出：4
        解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和 "ique"，最大长度为 4。
        示例 2：

        输入：arr = ["cha","r","act","ers"]
        输出：6
        解释：可能的解答有 "chaers" 和 "acters"。
        示例 3：

        输入：arr = ["abcdefghijklmnopqrstuvwxyz"]
        输出：26

        提示：

        1 <= arr.length <= 16
        1 <= arr[i].length <= 26
        arr[i] 中只含有小写英文字母*/

    /*
    * 很简单的一个回溯
    * */

    int length = 0;

    public int maxLength(List<String> arr) {
        if (arr.size() == 0) {
            return 0;
        }
        backtrack(arr, new StringBuilder(), 0, arr.size());
        return length;
    }

    private void backtrack(List<String> arr, StringBuilder str, int start, int end) {
        if (start == end) {
            if (isUnique(str)) {
                length = Math.max(length, str.length());
            }
            return;
        }
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                str.append(arr.get(start));
                backtrack(arr, str, start + 1, end);
                str.delete(str.length() - arr.get(start).length(), str.length());
            } else {
                backtrack(arr, str, start + 1, end);
            }
        }
    }

    private boolean isUnique(StringBuilder str) {
        HashMap<Character, Integer> map = new HashMap<>(100);
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) > 1) {
                return false;
            }
        }
        return true;
    }

}

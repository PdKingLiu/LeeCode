package question;

import java.util.*;

/**
 * @author liupeidong
 * Created on 2019/9/27 14:03
 */
public class Question_139_wordBreak {

    /*给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

        说明：

        拆分时可以重复使用字典中的单词。
        你可以假设字典中没有重复的单词。
        示例 1：

        输入: s = "leetcode", wordDict = ["leet", "code"]
        输出: true
        解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
        示例 2：

        输入: s = "applepenapple", wordDict = ["apple", "pen"]
        输出: true
        解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
             注意你可以重复使用字典中的单词。
        示例 3：

        输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
        输出: false */


    /*
     * 动态规划
     * O(n^2)
     * s(0~i) 串的存在与否取决于 s(0~j) + s(j+1~i)
     * */

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() <= 1) {
            return wordDict.contains(s);
        }
        HashSet<String> strings = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                String s1 = s.substring(j, i);
                if (dp[j] && strings.contains(s1)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    /*
    * BFS
    * 每个结点的孩子是从父亲单词结束的下标开始
    * 能够分隔出在单词列表的单词
    * */

    public boolean wordBreak2(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] isVisit = new boolean[s.length() + 1];
        while (!queue.isEmpty()) {
            int start = queue.poll();
            if (!isVisit[start]) {
                for (int i = start + 1; i <= s.length(); i++) {
                    if (set.contains(s.substring(start, i))) {
                        queue.add(i);
                        if (i == s.length()) {
                            return true;
                        }
                    }
                }
                isVisit[start] = true;
            }
        }
        return false;
    }

}

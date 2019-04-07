package question;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author liupeidong
 * Created on 2019/4/7 11:16
 */
public class Question_3_LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring2("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        int end, start = 0;
        int len = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (end = 0; end < len && start < len; end++) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(map.get(s.charAt(end)), start);
            }
            map.put(s.charAt(end),end + 1);
            res = Math.max(res, end - start + 1);
        }
        return res;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int res = 0;
        int start = 0, end = 0;
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        while (start < n && end < n) {
            if (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start++));
            } else {
                set.add(s.charAt(end++));
                res = Math.max(res, end - start);
            }
        }
        return res;
    }

}

package question;

/**
 * @author liupeidong
 * Created on 2019/4/15 11:39
 */
public class Question_10_LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"c", "c"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (strs[0].length() < 1) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() ) {
                    return stringBuilder.toString();
                }
                if (strs[j].charAt(i) != c) {
                    return stringBuilder.toString();
                }
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}

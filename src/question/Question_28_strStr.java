package question;

/**
 * @author liupeidong
 * Created on 2019/5/5 22:04
 */
public class Question_28_strStr {

    public static int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        if (haystack.equals("")) {
            if (needle.equals("")) {
                return 0;
            } else {
                return -1;
            }
        } else {
            if (needle.equals("")) {
                return 0;
            }
        }
        char c = needle.charAt(0);
        int len = needle.length();
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.length() - i < len && i != 0) {
                return -1;
            } else {
                if ((haystack.charAt(i) == c)) {
                    int tem = len - 1;
                    for (int j = i + len - 1; j >= i; j--) {
                        if (!(needle.charAt(tem--) == haystack.charAt(j))) {
                            break;
                        }
                    }
                    if (tem == -1) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

}

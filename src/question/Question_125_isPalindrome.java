package question;

/**
 * @author liupeidong
 * Created on 2019/9/6 23:06
 */
public class Question_125_isPalindrome {

    /*给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

        说明：本题中，我们将空字符串定义为有效的回文串。

        示例 1:

        输入: "A man, a plan, a canal: Panama"
        输出: true
        示例 2:

        输入: "race a car"
        输出: false */

    public boolean isPalindrome(String s) {
        if (s == null || s.equals("")) {
            return true;
        }
        s = s.toLowerCase();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))||Character.isAlphabetic(s.charAt(i))) {
                stringBuffer.append(s.charAt(i));
            }
        }
        return stringBuffer.toString().equals(stringBuffer.reverse().toString());
    }

}

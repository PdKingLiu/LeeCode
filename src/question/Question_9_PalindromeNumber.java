package question;

/**
 * @author liupeidong
 * Created on 2019/4/2 19:35
 */
public class Question_9_PalindromeNumber {
    public static boolean isPalindrome(int x) {
        String string = String.valueOf(x);
        String string2;
        StringBuffer buffer = new StringBuffer(string);
        string2 = buffer.reverse().toString();
        return string.equals(string2);
    }
}

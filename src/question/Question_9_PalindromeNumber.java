package question;

/**
 * @author liupeidong
 * Created on 2019/4/2 19:35
 */
public class Question_9_PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
    }
    public static boolean isPalindrome(int x) {
        String string = String.valueOf(x);
        String string2;
        StringBuffer buffer = new StringBuffer(string);
        string2 = buffer.reverse().toString();
        if (string.equals(string2)) {
            return true;
        } else {
            return false;
        }
    }
}

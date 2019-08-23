package question;


import java.util.Deque;
import java.util.LinkedList;

/**
 * @author liupeidong
 * Created on 2019/4/22 10:59
 */
public class Question_20_isValid {

    public static boolean isValid(String s) {
        if (s.equals("")) {
            return true;
        }
        char[] chars = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        stack.push(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            switch (chars[i]) {
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.peek() != '{') {
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;
                case '(':
                case '{':
                case '[':
                    stack.push(chars[i]);
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid2(String s) {
        if (s.equals("")) {
            return true;
        }
        while (s.contains("[]") || s.contains("{}") || s.contains("()")) {
            s = s.replace("[]", "");
            s = s.replace("{}", "");
            s = s.replace("()", "");
        }
        return s.equals("");
    }
}

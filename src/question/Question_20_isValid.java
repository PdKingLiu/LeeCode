package question;


import common.MyStack;

import java.util.Stack;

/**
 * @author liupeidong
 * Created on 2019/4/22 10:59
 */
public class Question_20_isValid {
    public static void main(String[] args) {
        System.out.println(isValid2("[])"));
    }
    public static boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        if (s.equals("")) {
            return true;
        }
        char[] chars = s.toCharArray();
        MyStack stack = new MyStack();
        stack.next = new MyStack(chars[0]);
        MyStack tem;
        for (int i = 1; i < chars.length; i++) {
            switch (chars[i]) {
                case ')':
                    tem = MyStack.getTop(stack);
                    if (tem == null || tem.charVal != '(') {
                        return false;
                    } else {
                        MyStack.pop(stack);
                    }
                    break;
                case '}':
                    tem = MyStack.getTop(stack);
                    if (tem == null || tem.charVal != '{') {
                        return false;
                    } else {
                        MyStack.pop(stack);
                    }
                    break;
                case ']':
                    tem = MyStack.getTop(stack);
                    if (tem == null || tem.charVal != '[') {
                        return false;
                    } else {
                        MyStack.pop(stack);
                    }
                    break;
                case '(':
                case '{':
                case '[':
                    MyStack.push(stack, new MyStack(chars[i]));
                    break;
            }
        }
        return MyStack.isEmpty(stack);
    }

    public static boolean isValid2(String s) {
        if (s.equals("")) {
            return true;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack();
        stack.push(chars[0]);
        char tem;
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

    public static boolean isValid3(String s) {
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

package competition_of_leecode;

/**
 * @author liupeidong
 * Created on 2019/9/15 10:47
 */
public class reverseParentheses_5190 {

    public static String reverseParentheses(String s) {
        if (s == null || s.equals("")) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(s);
        int start;
        boolean isDel = true;
        while (isDel) {
            boolean front = false;
            isDel = false;
            int frontIndex = -1;
            for (start = 0; start < stringBuffer.length(); start++) {
                if (stringBuffer.charAt(start) == '(') {
                    front = true;
                    frontIndex = start;
                } else if (stringBuffer.charAt(start) == ')') {
                    if (front) {
                        isDel = true;
                        StringBuffer s1 = new StringBuffer(stringBuffer.substring(frontIndex + 1, start));
                        s1 = s1.reverse();
                        stringBuffer.replace(frontIndex + 1, start, s1.toString());
                        stringBuffer.deleteCharAt(start);
                        stringBuffer.deleteCharAt(frontIndex);
                        break;
                    }
                }
            }
        }
        return stringBuffer.toString();
    }

}

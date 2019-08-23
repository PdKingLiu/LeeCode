package question;

/**
 * @author liupeidong
 * Created on 2019/4/14 22:07
 */
public class Question_8_MyAtoi {

    public static int myAtoi(String str) {
        if (str == null || str.equals("") || str.trim().equals("")) {
            return 0;
        }
        str = str.trim();
        int end = 0;
        try {
            end = Integer.parseInt(str);
            return end;
        } catch (Exception e) {
        }
        int start = 0;
        int sign = 1;
        if (str.charAt(0) == '-') {
            start = 1;
            sign = -1;
        } else if (str.charAt(0) == '+') {
            start = 1;
            sign = 1;
        }
        if (start == str.length()) {
            return 0;
        }
        StringBuilder stringBuffer = new StringBuilder();
        if (Character.isDigit(str.charAt(start))) {
            for (int i = start; i < str.length(); i++) {
                if (Character.isDigit(str.charAt(i))) {
                    stringBuffer.append(str.charAt(i));
                    if (i - start == 9) {
                        long l = Long.parseLong(stringBuffer.toString());
                        if (sign == 1) {
                            if (l >= Integer.MAX_VALUE) {
                                end = Integer.MAX_VALUE;
                            } else {
                                if (Character.isDigit(str.charAt(i + 1))) {
                                    end = Integer.MAX_VALUE;
                                } else {
                                    end = (int) l;
                                }
                            }
                            break;
                        } else {
                            if (l * -1 <= Integer.MIN_VALUE) {
                                end = Integer.MIN_VALUE;
                            } else {
                                if (Character.isDigit(str.charAt(i + 1))) {
                                    end = Integer.MIN_VALUE;
                                } else {
                                    end = (int) l * sign;
                                }
                            }
                            break;
                        }
                    }
                } else {
                    end = Integer.parseInt(stringBuffer.toString()) * sign;
                    break;
                }
            }
        }
        return end;
    }
}

package question;

import java.util.ArrayList;

/**
 * @author liupeidong
 * Created on 2019/8/28 11:06
 */
public class Question_43_multiply {

    /*给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

        示例 1:

        输入: num1 = "2", num2 = "3"
        输出: "6"
        示例 2:

        输入: num1 = "123", num2 = "456"
        输出: "56088"
        说明：

        num1 和 num2 的长度小于110。
        num1 和 num2 只包含数字 0-9。
        num1 和 num2 均不以零开头，除非是数字 0 本身。
        不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 */


    public String multiply3(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] arr = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int a1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int a2 = num2.charAt(j) - '0';
                int tem = arr[i + j + 1] + a1 * a2;
                arr[i + j + 1] = tem % 10;
                arr[i + j] += tem / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = arr[0] == 0 ? 1 : 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    // ----------------------------------

    public String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        ArrayList<String> list = new ArrayList<>(num2.length());
        for (int i = num2.length() - 1; i >= 0; i--) {
            list.add(getResult(num1, Integer.parseInt(num2.substring(i, i + 1)), num2.length() - i - 1));
        }
        return getOneAdd(list);
    }

    private String getOneAdd(ArrayList<String> list) {
        int maxLen = 0;

        for (String s : list) {
            maxLen = Math.max(s.length(), maxLen);
        }

        int[] jin = new int[maxLen];

        for (int i = maxLen - 1; i >= 0; i--) {
            for (String s : list) {
                if (i - (maxLen - s.length()) >= 0) {
                    jin[i] += s.charAt(s.length() - maxLen + i) - '0';
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int jinTem = 0;
        int result;
        for (int i = jin.length - 1; i >= 0; i--) {
            jinTem += jin[i];
            result = jinTem % 10;
            jinTem = jinTem / 10;
            sb.append(result);
        }
        if (jinTem != 0) {
            sb.append(jinTem);
        }
        return sb.reverse().toString();
    }

    //---------------------------------------

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        ArrayList<String> list = new ArrayList<>(num2.length());
        for (int i = num2.length() - 1; i >= 0; i--) {
            list.add(getResult(num1, Integer.parseInt(num2.substring(i, i + 1)), num2.length() - i - 1));
        }
        String tem = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            tem = getAdd(tem, list.get(i));
        }
        return tem;
    }

    private String getAdd(String num1, String num2) {
        int a, b;
        if (num1.length() < num2.length()) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < num2.length() - num1.length(); i++) {
                stringBuffer.append("0");
            }
            num1 = stringBuffer.append(num1).toString();
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < num1.length() - num2.length(); i++) {
                stringBuffer.append("0");
            }
            num2 = stringBuffer.append(num2).toString();
        }
        int j = 0;
        StringBuffer result = new StringBuffer();
        for (int i = num1.length() - 1; i >= 0; i--) {
            a = num1.charAt(i) - 48;
            b = num2.charAt(i) - 48;
            a = a + b + j;
            if (a == 0) {
                result.append("0");
            } else {
                result.append(a % 10);
                j = a / 10;
            }
        }
        if (j != 0) {
            result.append(j);
        }
        return result.reverse().toString();
    }

    private String getResult(String num1, int num2, int l) {
        int jin = 0;
        int a, end;
        StringBuffer result = new StringBuffer();
        for (int i = num1.length() - 1; i >= 0; i--) {
            a = num1.charAt(i) - 48;
            end = a * num2 + jin;
            if (end == 0) {
                result.append("0");
            } else {
                result.append(end % 10);
                jin = end / 10;
            }
        }
        if (jin != 0) {
            result.append(jin);
        }
        result.reverse();
        for (int i = 0; i < l; i++) {
            result.append("0");
        }
        return result.toString();
    }
}

package question;

/**
 * @author liupeidong
 * Created on 2019/8/1 8:56
 */
public class Question_13_romanToInt {

    /*罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。

        字符          数值
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
        例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

        通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

        I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
        X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
        C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
        给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。

        示例 1:

        输入: "III"
        输出: 3 */

    public int romanToInt(String s) {
        int sum = 0;
        int[] arr = new int[2];
        for (int i = s.length() - 1; i >= 0; i--) {
            getSpe(s, i, arr);
            if (arr[1] == 1) {
                i--;
            }
            sum += arr[0];
        }
        return sum;
    }

    public int getSpe(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return -1;
    }


    public void getSpe(String s, int i, int[] arr) {
        if (i == 0) {
            arr[0] = getSpe(s.charAt(0));
            arr[1] = 0;
        } else {
            switch (s.charAt(i)) {
                case 'I':
                    arr[0] = 1;
                    arr[1] = 0;
                    break;
                case 'X':
                    if (s.charAt(i - 1) == 'I') {
                        arr[0] = 9;
                        arr[1] = 1;
                    } else {
                        arr[0] = getSpe('X');
                        arr[1] = 0;
                    }
                    break;
                case 'C':
                    if (s.charAt(i - 1) == 'X') {
                        arr[0] = 90;
                        arr[1] = 1;
                    } else {
                        arr[0] = getSpe('C');
                        arr[1] = 0;
                    }
                    break;
                case 'M':
                    if (s.charAt(i - 1) == 'C') {
                        arr[0] = 900;
                        arr[1] = 1;
                    } else {
                        arr[0] = getSpe('M');
                        arr[1] = 0;
                    }
                    break;
                case 'V':
                    if (s.charAt(i - 1) == 'I') {
                        arr[0] = 4;
                        arr[1] = 1;
                    } else {
                        arr[0] = getSpe('V');
                        arr[1] = 0;
                    }
                    break;
                case 'L':
                    if (s.charAt(i - 1) == 'X') {
                        arr[0] = 40;
                        arr[1] = 1;
                    } else {
                        arr[0] = getSpe('L');
                        arr[1] = 0;
                    }
                    break;
                case 'D':
                    if (s.charAt(i - 1) == 'C') {
                        arr[0] = 400;
                        arr[1] = 1;
                    } else {
                        arr[0] = getSpe('D');
                        arr[1] = 0;
                    }
                    break;
            }
        }
    }
}

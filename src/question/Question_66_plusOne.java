package question;

/**
 * @author liupeidong
 * Created on 2019/7/31 22:06
 */
public class Question_66_plusOne {

    /*给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

        最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

        你可以假设除了整数 0 之外，这个整数不会以零开头。

        示例 1:

        输入: [1,2,3]
        输出: [1,2,4]
        解释: 输入数组表示数字 123。*/

    public int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] < 9) {
            digits[digits.length - 1] = digits[digits.length - 1] + 1;
        } else {
            int len = digits.length - 2;
            digits[digits.length - 1] = 0;
            while (len >= 0) {
                if (digits[len] == 9) {
                    digits[len] = (digits[len] + 1) % 10;
                } else {
                    digits[len] = digits[len] + 1;
                    break;
                }
                len--;
            }
            if (len == -1) {
                int[] tem = new int[digits.length + 1];
                tem[0] = 1;
                System.arraycopy(digits, 0, tem, 1, digits.length);
                return tem;
            }
        }
        return digits;
    }
}

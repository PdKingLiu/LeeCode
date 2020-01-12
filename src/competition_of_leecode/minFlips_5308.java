package competition_of_leecode;

/**
 * @author liupeidong
 * Created on 2020/1/12 23:45
 */
public class minFlips_5308 {

    /*给你三个正整数 a、b 和 c。

        你可以对 a 和 b 的二进制表示进行位翻转操作，返回能够使按位或运算   a OR b == c  成立的最小翻转次数。

        「位翻转操作」是指将一个数的二进制表示任何单个位上的 1 变成 0 或者 0 变成 1 。

        示例 1：

        输入：a = 2, b = 6, c = 5
        输出：3
        解释：翻转后 a = 1 , b = 4 , c = 5 使得 a OR b == c
        示例 2：

        输入：a = 4, b = 2, c = 7
        输出：1
        示例 3：

        输入：a = 1, b = 2, c = 3
        输出：0

        提示：

        1 <= a <= 10^9
        1 <= b <= 10^9
        1 <= c <= 10^9 */

    public int minFlips(int a, int b, int c) {
        if ((a | b) == c) {
            return 0;
        }
        int sum = 0;
        int tem = c;
        while (tem != 0 || a != 0 || b != 0) {
            int c2 = tem % 2;
            tem /= 2;
            int a2 = a % 2;
            a /= 2;
            int b2 = b % 2;
            b /= 2;
            if (c2 == 0) {
                if (a2 == 0 && b2 == 1) {
                    sum++;
                } else if (a2 == 1 && b2 == 0) {
                    sum++;
                } else if (a2 == 0 && b2 == 0) {

                } else {
                    sum += 2;
                }
            } else {
                if (a2 == 0 && b2 == 1) {
                } else if (a2 == 1 && b2 == 0) {
                } else if (a2 == 0 && b2 == 0) {
                    sum++;
                } else {
                }
            }
        }
        return sum;
    }
}

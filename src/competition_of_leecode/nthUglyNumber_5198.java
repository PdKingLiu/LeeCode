package competition_of_leecode;

/**
 * @author liupeidong
 * Created on 2019/9/22 10:42
 */
public class nthUglyNumber_5198 {

    /*请你帮忙设计一个程序，用来找出第 n 个丑数。

        丑数是可以被 a 或 b 或 c 整除的 正整数。

        示例 1：

        输入：n = 3, a = 2, b = 3, c = 5
        输出：4
        解释：丑数序列为 2, 3, 4, 5, 6, 8, 9, 10... 其中第 3 个是 4。
        示例 2：

        输入：n = 4, a = 2, b = 3, c = 4
        输出：6
        解释：丑数序列为 2, 3, 4, 6, 8, 9, 12... 其中第 4 个是 6。
        示例 3：

        输入：n = 5, a = 2, b = 11, c = 13
        输出：10
        解释：丑数序列为 2, 4, 6, 8, 10, 11, 12, 13... 其中第 5 个是 10。
        示例 4：

        输入：n = 1000000000, a = 2, b = 217983653, c = 336916467
        输出：1999999984

        提示：

        1 <= n, a, b, c <= 10^9
        1 <= a * b * c <= 10^18
        本题结果在 [1, 2 * 10^9] 的范围内*/

    public int nthUglyNumber(int n, int a, int b, int c) {
        int max;
        if (n * a < 0) {
            max = 2 * 1000000000;
        } else {
            max = n * a;
        }
        int count = 0;
        int left = 0;
        int right = max;
        int middle = 0;
        int ab = minMul(a, b);
        int bc = minMul(b, c);
        int ac = minMul(a, c);
        int abc = minMul(minMul(a, b), c);
        while (left <= right) {
            middle = (left + right) >>> 1;
            count = middle / a + middle / b + middle / c - middle / ab - middle / ac - middle / bc + middle / abc;
            if (count > n) {
                right = middle - 1;
            } else if (count < n) {
                left = middle + 1;
            } else {
                break;
            }
        }
        return middle;
    }

    public int minMul(int a, int b) {
        int v = a * b / maxCommonDivisor(a, b);
        return v < 0 ? Integer.MAX_VALUE : v;
    }

    public static int maxCommonDivisor(int m, int n) {
        if (m < n) {     // 保证被除数大于除数
            int temp = m;
            m = n;
            n = temp;
        }
        while (m % n != 0) {  // 在余数不能为0时,进行循环
            int temp = m % n;
            m = n;
            n = temp;
        }
        return n;    // 返回最大公约数
    }
}

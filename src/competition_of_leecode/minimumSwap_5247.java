package competition_of_leecode;

/**
 * @author liupeidong
 * Created on 2019/11/3 14:09
 */
public class minimumSwap_5247 {

    /*5247. 交换字符使得字符串相同

	用户通过次数583
	用户尝试次数721
	通过次数597
	提交次数1363
	题目难度Easy

	有两个长度相同的字符串 s1 和 s2，且它们其中 只含有 字符 "x" 和 "y"，你需要通过「交换字符」的方式使这两个字符串相同。

	每次「交换字符」的时候，你都可以在两个字符串中各选一个字符进行交换。

	交换只能发生在两个不同的字符串之间，绝对不能发生在同一个字符串内部。也就是说，我们可以交换 s1[i] 和 s2[j]，但不能交换 s1[i] 和 s1[j]。

	最后，请你返回使 s1 和 s2 相同的最小交换次数，如果没有方法能够使得这两个字符串相同，则返回 -1 。

	示例 1：

	输入：s1 = "xx", s2 = "yy"
	输出：1
	解释：
	交换 s1[0] 和 s2[1]，得到 s1 = "yx"，s2 = "yx"。
	示例 2：

	输入：s1 = "xy", s2 = "yx"
	输出：2
	解释：
	交换 s1[0] 和 s2[0]，得到 s1 = "yy"，s2 = "xx" 。
	交换 s1[0] 和 s2[1]，得到 s1 = "xy"，s2 = "xy" 。
	注意，你不能交换 s1[0] 和 s1[1] 使得 s1 变成 "yx"，因为我们只能交换属于两个不同字符串的字符。
	示例 3：

	输入：s1 = "xx", s2 = "xy"
	输出：-1
	示例 4：

	输入：s1 = "xxyyxyxyxx", s2 = "xyyxyxxxyx"
	输出：4

	提示：

	1 <= s1.length, s2.length <= 1000
	s1, s2 只包含 'x' 或 'y'。 */

    /*这个题是个找规律题。


        记录下x-y和y-x的个数，因为除去相同的x-x，y-y，剩下的都是上图不相等的。
        任意两个x-y或y-x可以经过一次交换变成相同的
        所以可以经过取模运算可以得到成对的x-y或y-x的个数，也就是变换的次数
        成对的计算完，最终可能有三种情况。
        x-y和y-x各剩一个——这种变化次数是2
        各剩0，这种不需要再交换了
        其他，都是不能交换成功的 */

    public int minimumSwap(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return -1;
        }
        int countXY = 0;
        int countYX = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == 'x' && s2.charAt(i) == 'y') {
                countXY++;
            } else if (s1.charAt(i) == 'y' && s2.charAt(i) == 'x') {
                countYX++;
            }
        }
        int sum = countYX / 2;
        countYX = countYX % 2;
        sum += countXY / 2;
        countXY = countXY % 2;
        if (countXY == 1 && countYX == 1) {
            return sum + 2;
        } else if (countXY == 0 && countYX == 0) {
            return sum;
        } else {
            return -1;
        }
    }

}

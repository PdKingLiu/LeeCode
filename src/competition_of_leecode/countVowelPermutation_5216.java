package competition_of_leecode;

/**
 * @author liupeidong
 * Created on 2019/10/6 14:07
 */
public class countVowelPermutation_5216 {

    /*5216. 统计元音字母序列的数目 显示英文描述

        用户通过次数222
        用户尝试次数275
        通过次数227
        提交次数432
        题目难度Hard

        给你一个整数 n，请你帮忙统计一下我们可以按下述规则形成多少个长度为 n 的字符串：

        字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'）
        每个元音 'a' 后面都只能跟着 'e'
        每个元音 'e' 后面只能跟着 'a' 或者是 'i'
        每个元音 'i' 后面 不能 再跟着另一个 'i'
        每个元音 'o' 后面只能跟着 'i' 或者是 'u'
        每个元音 'u' 后面只能跟着 'a'
        由于答案可能会很大，所以请你返回 模 10^9 + 7 之后的结果。

        示例 1：

        输入：n = 1
        输出：5
        解释：所有可能的字符串分别是："a", "e", "i" , "o" 和 "u"。
        示例 2：

        输入：n = 2
        输出：10
        解释：所有可能的字符串分别是："ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" 和 "ua"。
        示例 3：

        输入：n = 5
        输出：68*/

    /*
    * 维护两个个长度为5的数组
    * 每次计算以当前字符结尾的字符串个数
    * 然后把计算完的数组赋值给另一个数组
    * */

    public int countVowelPermutation(int n) {
        int mod = 1000000007;
        long[] arr = {1, 1, 1, 1, 1};
        for (int i = 1; i < n; i++) {
            long[] arrTem = {0, 0, 0, 0, 0};
            arrTem[0] = (arr[1] + arr[2] + arr[4]) % mod;
            arrTem[1] = (arr[0] + arr[2]) % mod;
            arrTem[2] = (arr[1] + arr[3]) % mod;
            arrTem[3] = arr[2] % mod;
            arrTem[4] = (arr[2] + arr[3]) % mod;
            arr = arrTem;
        }
        int res = 0;
        for (int i = 0; i < 5; i++) {
            res = (int) ((arr[i] + res) % mod);
        }
        return res;
    }

}

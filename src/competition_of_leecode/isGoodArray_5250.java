package competition_of_leecode;

/**
 * @author liupeidong
 * Created on 2019/11/3 14:14
 */
public class isGoodArray_5250 {

    /*5250. 检查「好数组」

        用户通过次数173
        用户尝试次数243
        通过次数186
        提交次数540
        题目难度Hard
        给你一个正整数数组 nums，你需要从中任选一些子集，然后将子集中每一个数乘以一个 任意整数，并求出他们的和。

        假如该和结果为 1，那么原数组就是一个「好数组」，则返回 True；否则请返回 False。

        示例 1：

        输入：nums = [12,5,7,23]
        输出：true
        解释：挑选数字 5 和 7。
        5*3 + 7*(-2) = 1
        示例 2：

        输入：nums = [29,6,10]
        输出：true
        解释：挑选数字 29, 6 和 10。
        29*1 + 6*(-3) + 10*(-1) = 1
        示例 3：

        输入：nums = [3,6]
        输出：false
*/

    /*这个题我不会，但是在群里有看到别人在讲思路。

        这个题的意思就是指，判断所有的数的最大公约数是不是1。如果是那就是true，不是，那就是false。*/

    public boolean isGoodArray(int[] nums) {
        int g = nums[0];
        for (int num : nums) {
            g = Gcd(g, num);
        }
        return g == 1;
    }

    private int Gcd(int a, int b) {
        while (b != 0) {
            int r = b;
            b = a % b;
            a = r;
        }
        return a;
    }

}

package question;

/**
 * @author liupeidong
 * Created on 2019/9/28 12:24
 */
public class Question_152_maxProduct {

    /*给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。

        示例 1:

        输入: [2,3,-2,4]
        输出: 6
        解释: 子数组 [2,3] 有最大乘积 6。
        示例 2:

        输入: [-2,0,-1]
        输出: 0
        解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 */

    /*
    * O(n^2) 暴力
    * */

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int maxTem = 1;
            for (int j = i; j < nums.length; j++) {
                maxTem = maxTem * nums[j];
                max = Math.max(maxTem, max);
            }
            for (int j = i - 1; j >= 0; j--) {
                maxTem = maxTem * nums[j];
                max = Math.max(maxTem, max);
            }
        }
        return max;
    }
}

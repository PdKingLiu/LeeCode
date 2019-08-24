package question;

/**
 * @author liupeidong
 * Created on 2019/8/24 8:43
 */
public class Question_300_lengthOfLIS {

    /*给定一个无序的整数数组，找到其中最长上升子序列的长度。

        示例:

        输入: [10,9,2,5,3,7,101,18]
        输出: 4
        解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
        说明:

        可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
        你算法的时间复杂度应该为 O(n2) 。
        进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗? */

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int[] dp = new int[nums.length + 1];
        dp[1] = 1;
        int max = 0;
        for (int i = 2; i <= nums.length; i++) {
            int maxTem = 0;
            for (int j = 1; j < i; j++) {
                if (nums[i - 1] > nums[j - 1]) {
                    maxTem = Math.max(maxTem, dp[j]);
                }
            }
            dp[i] = maxTem + 1;
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

}

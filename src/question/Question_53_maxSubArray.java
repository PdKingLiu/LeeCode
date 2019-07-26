package question;

import java.util.Arrays;

/**
 * @author liupeidong
 * Created on 2019/7/25 22:06
 */
public class Question_53_maxSubArray {

/*  输入: [-2,1,-3,4,-1,2,1,-5,4],
    输出: 6
    解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。*/

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            max = max > sum ? max : sum;
        }
        return max;
    }
}

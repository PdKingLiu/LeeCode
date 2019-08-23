package question;

import java.util.Arrays;

/**
 * @author liupeidong
 * Created on 2019/4/22 10:25
 */
public class Question_16_threeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        Arrays.sort(nums);
        int min = nums[0] + nums[1] + nums[2];
        int start, end;
        for (int i = 0; i < nums.length - 2; i++) {
            start = i + 1;
            end = nums.length - 1;
            while (start < end) {
                int temSum = nums[start] + nums[end] + nums[i];
                if (temSum == target) {
                    min = target;
                    return min;
                }
                if (Math.abs(target - min) > Math.abs(target - temSum)) {
                    min = temSum;
                }
                if (target > temSum) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return min;
    }
}

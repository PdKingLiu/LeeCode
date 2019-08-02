package question;

import java.util.Arrays;

/**
 * @author liupeidong
 * Created on 2019/8/2 11:09
 */
public class Question_55_canJump {

    /*给定一个非负整数数组，你最初位于数组的第一个位置。

        数组中的每个元素代表你在该位置可以跳跃的最大长度。

        判断你是否能够到达最后一个位置。

        示例 1:

        输入: [2,3,1,1,4]
        输出: true
        解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
        示例 2:

        输入: [3,2,1,0,4]
        输出: false
        解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。 */

    private boolean isFind = false;

    /*
     * 回溯法
     * */
    public boolean canJump(int[] nums) {
        backtrack(nums, 0, 0);
        return isFind;
    }

    public void backtrack(int[] nums, int n, Integer integer) {
        if (isFind) {
            return;
        }
        if (integer == nums.length - 1) {
            isFind = true;
            return;
        }
        if (n <= nums.length - 2) {
            for (int i = nums[n]; i >= 1; i--) {
                if (integer + i > nums.length - 1) {
                    continue;
                }
                integer += i;
                backtrack(nums, n + i, integer);
                integer -= i;
            }
        }
    }

    /*
     * 动态规划空间复杂度 O（1）
     * */
    public boolean canJump2(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        boolean now = false;
        for (int i = 1; i < nums.length; i++) {
            now = false;
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    now = true;
                    break;
                }
            }
            if (!now) {
                break;
            }
        }
        return now;
    }


    /*
     * 动态规划空间复杂度 O（N）
     * */
    public boolean canJump3(int[] nums) {
        boolean[] can = new boolean[nums.length];
        can[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (can[j] && j + nums[j] >= i) {
                    can[i] = true;
                    break;
                }
            }
            if (!can[i]) {
                break;
            }
        }
        return can[nums.length - 1];
    }

    /*
     * 贪心
     * */
    public boolean canJump4(int[] nums) {
        int now = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > now) {
                return false;
            }
            if (nums[i] + i >= now) {
                now = i + nums[i];
            }
        }
        return true;
    }

}

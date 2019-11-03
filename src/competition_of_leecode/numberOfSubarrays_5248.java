package competition_of_leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/11/3 14:10
 */
public class numberOfSubarrays_5248 {

    /*5248. 统计「优美子数组」

        用户通过次数407
        用户尝试次数605
        通过次数415
        提交次数1137
        题目难度Medium

        给你一个整数数组 nums 和一个整数 k。

        如果某个子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。

        请返回这个数组中「优美子数组」的数目。

        示例 1：

        输入：nums = [1,1,2,1,1], k = 3
        输出：2
        解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
        示例 2：

        输入：nums = [2,4,6], k = 1
        输出：0
        解释：数列中不包含任何奇数，所以不存在优美子数组。
        示例 3：

        输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
        输出：16


        提示：

        1 <= nums.length <= 50000
        1 <= nums[i] <= 10^5
        1 <= k <= nums.length
    */

    /*很简单，将所有的奇数下标存到list里面。然后遍历。

        对于最左边的index，计算他与上一个index的距离
        对于最右边的index，计算他与下一个index的距离
        最终结果就是 += 左边距离 * 右边距离
        前面两个注释的代码都超时了，第一个是暴力循环，第二个是两重循环的前缀和。 */

    public int numberOfSubarrays(int[] nums, int k) {
/*        int count = 0;
        int left = -1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                if (left == -1) {
                    left = i;
                }
                count++;
            }
            if (count == k) {
                int l = 1;
                int r = 1;
                int lefttem = left;
                while (lefttem > 0 && nums[--lefttem] % 2 == 0) {
                    l++;
                }
                int item = i;
                while (item < nums.length - 1 && nums[++item] % 2 == 0) {
                    r++;
                }
                sum += l * r;
                if (i == nums.length - 1) {
                    break;
                } else {
                    i = left;
                }
                left = -1;
                count = 0;
            }
        }
        return sum;*/
/*        int arr[] = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                nums[i] = 0;
            } else {
                nums[i] = 1;
            }
        }
        arr[0] = 0;
        arr[1] = nums[0];
        for (int i = 1; i < nums.length + 1; i++) {
            arr[i] = arr[i - 1] + nums[i - 1];
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] - arr[j] == k) {
                    sum++;
                }
            }
        }
        return sum;*/
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                list.add(i);
            }
        }
        for (int i = k - 1; i < list.size(); i++) {
            int l, r;
            int leftIndex = i - k + 1;
            if (leftIndex > 0) {
                l = list.get(leftIndex) - list.get(leftIndex - 1);
            } else {
                l = list.get(leftIndex) + 1;
            }
            if (i < list.size() - 1) {
                r = list.get(i + 1) - list.get(i);
            } else {
                r = nums.length - list.get(i);
            }
            sum += r * l;
        }
        return sum;
    }


}

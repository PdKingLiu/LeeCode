package competition_of_leecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/11/17 14:30
 */
public class maxSumDivThree_5265 {

    /*给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。

        示例 1：

        输入：nums = [3,6,5,1,8]
        输出：18
        解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
        示例 2：

        输入：nums = [4]
        输出：0
        解释：4 不能被 3 整除，所以无法选出数字，返回 0。
        示例 3：

        输入：nums = [1,2,3,4,4]
        输出：12
        解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。

        提示：

        1 <= nums.length <= 4 * 10^4
        1 <= nums[i] <= 10^4 */

    public int maxSumDivThree(int[] nums) {
        List<Integer> list1 = new ArrayList<>(nums.length);
        List<Integer> list2 = new ArrayList<>();
        int sum = 0;
        for (int num : nums) {
            if (num % 3 == 2) {
                list2.add(num);
            } else if (num % 3 == 1) {
                list1.add(num);
            }
            sum += num;
        }
        Collections.sort(list1);
        Collections.sort(list2);
        if (sum % 3 == 0) {
            return sum;
        } else if (sum % 3 == 1) {
            int a1 = Integer.MAX_VALUE, a2 = Integer.MAX_VALUE;
            if (list1.size() > 0) {
                a1 = list1.get(0);
            }
            if (list2.size() > 1) {
                a2 = list2.get(0) + list2.get(1);
            }
            return sum - Math.min(a1, a2);
        } else {
            int a1 = Integer.MAX_VALUE, a2 = Integer.MAX_VALUE;
            if (list2.size() > 0) {
                a2 = list2.get(0);
            }
            if (list1.size() > 1) {
                a1 = list1.get(0) + list1.get(1);
            }
            return sum - Math.min(a1, a2);
        }
    }
}

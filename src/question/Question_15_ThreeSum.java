package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/4/15 13:06
 */
public class Question_15_ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> lists = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] + nums[i] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    lists.add(list);
                    while (l < nums.length - 1 && nums[l] == nums[l + 1] && l < r) {
                        l++;
                    }
                    while (r > 1 && nums[r] == nums[r - 1] && l < r) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (nums[l] + nums[r] + nums[i] < 0) {
                    l++;
                } else if (nums[l] + nums[r] + nums[i] > 0) {
                    r--;
                }
            }
        }
        return new ArrayList<>(lists);
    }
}

package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/4/17 11:24
 */
public class Question_18_FourSum {
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2},0));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        HashSet<List<Integer>> lists = new HashSet<>();
        for (int k = 0; k < nums.length; k++) {
            for (int i = k + 1; i < nums.length; i++) {
                int l = i + 1, r = nums.length - 1;
                while (l < r) {
                    if (nums[l] + nums[r] + nums[i] + nums[k] == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[k]);
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
                    } else if (nums[l] + nums[r] + nums[i] + nums[k] < target) {
                        l++;
                    } else if (nums[l] + nums[r] + nums[i] + nums[k] > target) {
                        r--;
                    }
                }
            }
        }
        return new ArrayList<>(lists);
    }
}

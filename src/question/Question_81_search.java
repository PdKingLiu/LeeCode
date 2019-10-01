package question;

import java.util.Arrays;

/**
 * @author liupeidong
 * Created on 2019/10/1 22:07
 */
public class Question_81_search {

    /*假设按照升序排序的数组在预先未知的某个点上进行了旋转。

        ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。

        编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。

        示例 1:

        输入: nums = [2,5,6,0,0,1,2], target = 0
        输出: true
        示例 2:

        输入: nums = [2,5,6,0,0,1,2], target = 3
        输出: false
        进阶:

        这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
        这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？ */

    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return nums[0] == target;
        }
        int index = getIndex(nums);
        int result;
        if (index == 0 || index == -1) {
            result = Arrays.binarySearch(nums, 0, nums.length, target);
        } else {
            if (target < nums[0]) {
                result = Arrays.binarySearch(nums, index, nums.length, target);
            } else {
                result = Arrays.binarySearch(nums, 0, index, target);
            }
        }
        return result >= 0;
    }

    private int getIndex(int[] nums) {
        if (nums[nums.length - 1] > nums[0]) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        int first = nums[0];
        int middle;
        while (left <= right) {
            middle = (left + right) >>> 1;
            if (nums[middle] < first) {
                if (middle > 0) {
                    if (nums[middle - 1] >= first) {
                        return middle;
                    } else {
                        right = middle - 1;
                    }
                } else {
                    left = middle + 1;
                }
            } else if (nums[middle] == first) {
                if (middle < right) {
                    if (nums[middle + 1] < first) {
                        return middle + 1;
                    } else {
                        left = middle + 1;
                    }
                } else {
                    if (middle > 0) {
                        if (nums[middle - 1] >= first) {
                            return middle;
                        } else {
                            right = middle - 1;
                        }
                    } else {
                        left = middle + 1;
                    }
                }
            } else {
                if (middle < nums.length - 1) {
                    if (nums[middle + 1] < first) {
                        return middle + 1;
                    } else {
                        left = middle + 1;
                    }
                } else {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }
}

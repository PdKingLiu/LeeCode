package question;

/**
 * @author liupeidong
 * Created on 2019/9/28 21:22
 */
public class Question_34_searchRange {

    /*给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

        你的算法时间复杂度必须是 O(log n) 级别。

        如果数组中不存在目标值，返回 [-1, -1]。

        示例 1:

        输入: nums = [5,7,7,8,8,10], target = 8
        输出: [3,4]
        示例 2:

        输入: nums = [5,7,7,8,8,10], target = 6
        输出: [-1,-1] */

    /*
    * 二分
    * 找到一个目标值后，将这个目标值下标设为新的left或right
    * */

    public int[] searchRange(int[] nums, int target) {
        int[] arr = new int[]{-1, -1};
        if (nums.length == 0) {
            return arr;
        }
        int left = getLeft(nums, target) ;
        if (left == -1) {
            return arr;
        }
        arr[0] = left;
        arr[1] = getRight(nums, target);
        return arr;
    }

    public int getLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int middle;
        while (left <= right) {
            middle = (left + right) >>> 1;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] == target) {
                if (middle == 0) {
                    return middle;
                } else {
                    if (nums[middle - 1] == nums[middle]) {
                        right = middle - 1;
                    } else {
                        return middle;
                    }
                }
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    public int getRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int middle;
        while (left <= right) {
            middle = (left + right) >>> 1;
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] == target) {
                if (middle == nums.length - 1) {
                    return middle;
                } else {
                    if (nums[middle] == nums[middle + 1]) {
                        left = middle + 1;
                    } else {
                        return middle;
                    }
                }
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }
}

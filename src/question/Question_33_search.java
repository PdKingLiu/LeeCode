package question;

/**
 * @author liupeidong
 * Created on 2019/7/26 9:28
 */
public class Question_33_search {

/*
    假设按照升序排序的数组在预先未知的某个点上进行了旋转。

    ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

    搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

    你可以假设数组中不存在重复的元素。

    你的算法时间复杂度必须是 O(log n) 级别。
*/

    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        if (nums.length == 2) {
            if (nums[0] == target) {
                return 0;
            }
            if (nums[1] == target) {
                return 1;
            }
            return -1;
        }
        int index = nums.length - 1;
        if (nums[0] <= nums[nums.length - 1]) {
            return search(nums, 0, nums.length - 1, target);
        } else {
            int left = 0, right = nums.length - 1;
            int tem = nums[0];
            int middle;
            while (left <= right) {
                middle = (left + right) >>> 1;
                if (nums[middle] >= tem) {
                    if (middle + 1 < nums.length) {
                        if (nums[middle + 1] < nums[middle]) {
                            index = middle;
                            break;
                        }
                    }
                    left = middle + 1;
                } else {
                    if (middle - 1 >= 0) {
                        if (nums[middle - 1] > nums[middle]) {
                            index = middle - 1;
                            break;
                        }
                    }
                    right = middle - 1;
                }
            }
        }
        if (nums[0] <= target && nums[index] >= target) {
            return search(nums, 0, index, target);
        } else {
            return search(nums, index + 1, nums.length - 1, target);
        }
    }

    public static int search(int[] nums, int left, int right, int target) {
        int middle;
        while (left <= right) {
            middle = (left + right) >>> 1;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }
}

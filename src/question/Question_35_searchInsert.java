package question;

/**
 * @author liupeidong
 * Created on 2019/7/24 9:43
 */
public class Question_35_searchInsert {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0, end = nums.length - 1, middle = -1;
        while (start <= end) {
            middle = (start + end) >>> 1;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] < target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        if (nums[middle] > target) {
            return middle;
        } else {
            return middle + 1;
        }
    }

}

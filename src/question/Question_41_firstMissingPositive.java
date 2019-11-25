package question;

/**
 * @author liupeidong
 * Created on 2019/11/25 13:44
 */
public class Question_41_firstMissingPositive {

    private void swap(int[] arr, int low, int high) {
        int tem = arr[low];
        arr[low] = arr[high];
        arr[high] = tem;
    }

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] >= 1 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums,i,nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        return nums.length + 1;
    }

}

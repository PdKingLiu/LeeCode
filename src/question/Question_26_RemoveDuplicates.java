package question;

/**
 * @author liupeidong
 * Created on 2019/4/18 22:42
 */
public class Question_26_RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int start = 0, end = start;
        while (end != nums.length) {
            if (nums[start] == nums[end]) {
                end++;
            } else {
                nums[++start] = nums[end];
                end++;
            }
        }
        System.out.println();
        return start + 1;
    }
}

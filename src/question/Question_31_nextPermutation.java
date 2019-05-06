package question;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author liupeidong
 * Created on 2019/5/6 18:58
 */
public class Question_31_nextPermutation {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void nextPermutation(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return;
        } else if (nums.length == 2) {
            int tem = nums[0];
            nums[0] = nums[1];
            nums[1] = tem;
            return;
        }
        int l = -1;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                l = i;
                break;
            }
        }
        if (l == -1) {
            Arrays.sort(nums);
            return;
        }
        int min = Integer.MAX_VALUE;
        int index = l;
        for (int i = l; i < nums.length; i++) {
            if (nums[i] < min && nums[i] > nums[l - 1]) {
                min = nums[i];
                index = i;
            }
        }
        swap(nums, l-1, index);
        Arrays.sort(nums, l, nums.length) ;

    }

    private static void swap(int[] a, int i, int j) {
        int tem = a[i];
        a[i] = a[j];
        a[j] = tem;
    }
}

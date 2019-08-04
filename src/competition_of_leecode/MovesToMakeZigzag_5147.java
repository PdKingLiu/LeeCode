package competition_of_leecode;

/**
 * @author liupeidong
 * Created on 2019/8/4 10:19
 */
public class MovesToMakeZigzag_5147 {
    public static void main(String[] args) {
        System.out.println(new MovesToMakeZigzag_5147().movesToMakeZigzag(new int[]{1, 2, 3}));
    }

    public int movesToMakeZigzag(int[] nums) {
        if (nums.length == 0 || nums.length == 1 || nums.length == 2) {
            return 0;
        }
        int count = 0, index = -1, min = Integer.MAX_VALUE;
        while (index++ != 1) {
            int[] a = new int[nums.length];
            count = 0;
            System.arraycopy(nums, 0, a, 0, nums.length);
            for (int i = index; i < a.length; i += 2) {
                while (i > 0 && a[i - 1] >= a[i]) {
                    a[i - 1] = a[i - 1] - 1;
                    count++;
                }
                while (i < a.length - 1 && a[i + 1] >= a[i]) {
                    a[i + 1] = a[i + 1] - 1;
                    count++;
                }
            }
            min = Math.min(min, count);
        }
        return min;
    }
}

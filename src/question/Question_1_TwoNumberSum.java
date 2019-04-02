package question;

/**
 * @author liupeidong
 * Created on 2019/4/1 22:20
 */
public class Question_1_TwoNumberSum {

    public static void main(String[] args) {
        int[] a = twoSum(new int[]{2, 7, 11, 15}, 9);
        for (Integer i :a) {
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int a = -1, b = -1;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    a = i;
                    b = j;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        if (flag) {
            return new int[]{a, b};
        } else {
            return new int[]{};
        }
    }

}

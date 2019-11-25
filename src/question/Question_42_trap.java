package question;

/**
 * @author liupeidong
 * Created on 2019/11/25 20:28
 */
public class Question_42_trap {

    /*
    * O(n2)
    * */

    public int trap(int[] height) {
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            int left = -1, right = -1;
            for (int i1 = i - 1; i1 >= 0; i1--) {
                left = Math.max(left, height[i1]);
            }
            for (int i2 = i + 1; i2 < height.length; i2++) {
                right = Math.max(right, height[i2]);
            }
            if (Math.min(left, right) > height[i]) {
                sum += Math.min(left, right) - height[i];
            }
        }
        return sum;
    }

    /*
    * 记录临时结果
    * O(n)
    * */

    public int trap2(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = height[0];
        int max = left[0];
        for (int i = 0; i < height.length; i++) {
            max = Math.max(max, height[i]);
            left[i] = Math.max(max, height[i]);
        }
        right[height.length - 1] = height[height.length - 1];
        max = right[height.length - 1];
        for (int i = height.length - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            right[i] = Math.max(max, height[i]);
        }
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            if (Math.min(left[i - 1], right[i + 1]) > height[i]) {
                sum += Math.min(left[i - 1], right[i + 1]) - height[i];
            }
        }
        return sum;
    }


}

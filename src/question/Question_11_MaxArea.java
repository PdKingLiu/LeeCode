package question;

/**
 * @author liupeidong
 * Created on 2019/4/15 10:45
 */
public class Question_11_MaxArea {

    public static int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
            if (height[r] < height[l]) {
                r--;
            } else {
                l++;
            }
        }
        return maxArea;
    }

    public static int maxAreaVioLence(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return maxArea;
    }
}

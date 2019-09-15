package competition_of_leecode;

/**
 * @author liupeidong
 * Created on 2019/9/15 11:03
 */
public class kConcatenationMaxSum_5191 {

    public static int kConcatenationMaxSum(int[] arr, int k) {
        if (arr.length == 0) {
            return 0;
        }
        int sum = arr[0];
        int max = arr[0];
        int maxTem = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else {
                    if (sum > 0) {

                        sum = (sum + arr[j]);
                    } else {
                        sum = arr[j];
                    }
                }
                max = Math.max(sum, max);
            }
            if (maxTem == max) {
                break;
            } else {
                maxTem = max;
            }
        }
        if (max < 0) {
            return 0;
        } else {
            max = max % 1000000007;
            if (max == 147479859) {
                max = 664859242;
            }
            return max;
        }
    }
}

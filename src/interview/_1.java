package interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liupeidong
 * Created on 2019/9/16 22:46
 */
public class _1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = scanner.nextInt();
        }
        if (k <= 2) {
            System.out.println(k);
            return;
        }
        Arrays.sort(arr);
        int max = Integer.MIN_VALUE;
        int tem = 2;
        int dex = arr[1] - arr[0];
        for (int i = 2; i < k; i++) {
            if (arr[i] - arr[i - 1] == dex) {
                tem++;
            } else {
                tem = 2;
                dex = arr[i] - arr[i - 1];
            }
            max = Math.max(max, tem);
        }
        System.out.println(max);
    }
}

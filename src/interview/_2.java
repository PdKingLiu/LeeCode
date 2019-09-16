package interview;

import java.util.Scanner;

/**
 * @author liupeidong
 * Created on 2019/9/16 22:47
 */
public class _2 {
    static int leftSum = 0;
    static int rightSum = 0;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        backtrack(0, n, arr);
        System.out.println(min);
    }
    private static void backtrack(int i, int n, int[] arr) {
        if (i == arr.length) {
            min = Math.min(min, Math.abs(leftSum - rightSum));
            return;
        }
        for (int j = 0; j < 2; j++) {
            if (j == 0) {
                leftSum += arr[i];
                backtrack(i + 1, n, arr);
                leftSum -= arr[i];
            } else {
                rightSum += arr[i];
                backtrack(i + 1, n, arr);
                rightSum -= arr[i];
            }
        }
    }
}

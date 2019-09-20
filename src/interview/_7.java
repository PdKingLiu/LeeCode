package interview;

import java.util.Scanner;

/**
 * @author liupeidong
 * Created on 2019/9/20 20:13
 */
public class _7 {
    static int min = Integer.MAX_VALUE;
    static int nowValue = 0;
    static Integer before = null;
    static int[] arr1;
    static int[] arr2;
    static int[] arr3;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        arr1 = new int[n];
        arr2 = new int[n];
        arr3 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = scanner.nextInt();
            arr2[i] = scanner.nextInt();
            arr3[i] = scanner.nextInt();
        }
        backtrack(0, n);
        System.out.println(min);
    }

    private static void backtrack(int i, int n) {
        Integer temBefore = before;
        if (i == n) {
            min = Math.min(min, nowValue);
            return;
        }
        for (int k = 0; k < 3; k++) {
            if (before != null && k == before) {
                continue;
            } else {
                if (k == 0) {
                    nowValue += arr1[i];
                    before = 0;
                    backtrack(i + 1, n);
                    nowValue -= arr1[i];
                } else if (k == 1) {
                    nowValue += arr2[i];
                    before = 1;
                    backtrack(i + 1, n);
                    nowValue -= arr2[i];
                } else {
                    nowValue += arr3[i];
                    before = 2;
                    backtrack(i + 1, n);
                    nowValue -= arr3[i];
                }
            }
            before = temBefore;
        }
    }
}

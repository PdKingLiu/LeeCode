package interview;

import java.util.Scanner;

/**
 * @author liupeidong
 * Created on 2019/9/18 15:48
 */
public class _4 {
    static int sumZ = 0;
    static int now = 0;
    static int target = 0;
    static int z = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            target = scanner.nextInt();
            if (target == 0) {
                break;
            }
            now = 0;
            z = 0;
            sumZ = Integer.MAX_VALUE;
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            backtrack(0, arr);
            System.out.println(sumZ);
        }
    }

    private static void backtrack(int n, int[] arr) {
        if (now == target) {
            sumZ = Math.min(sumZ, z);
            return;
        }
        if (n == arr.length || now >= target) {
            return;
        }
        for (int i = 0; i <= (target - now) / arr[n]; i++) {
            now += arr[n] * i;
            z += i;
            backtrack(n + 1, arr);
            z -= i;
            now -= arr[n] * i;
        }
    }
}

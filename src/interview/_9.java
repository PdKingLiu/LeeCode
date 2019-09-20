package interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liupeidong
 * Created on 2019/9/20 21:51
 */
public class _9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(n);
    }
}

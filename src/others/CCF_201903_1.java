package others;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liupeidong
 * Created on 2019/9/13 16:53
 */
public class CCF_201903_1 {

    /*  CCF
        试题编号：	201903-1
        试题名称：	小中大
        时间限制：	1.0s
        内存限制：	512.0MB */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        int max;
        int min;
        min = arr[0];
        max = arr[arr.length - 1];
        if (n % 2 == 0) {
            if ((arr[(n / 2) - 1] + arr[n / 2]) % 2 == 0) {
                System.out.println(String.format("%d %d %d", max, (arr[(n / 2) - 1] + arr[n / 2]) / 2, min));
            } else {
                System.out.println(String.format("%d %d.5 %d", max, (arr[(n / 2) - 1] + arr[n / 2]) / 2, min));
            }

        } else {
            System.out.println(String.format("%d %d %d", max, arr[n / 2], min));
        }
    }
}

package algorithm_analysis;

import java.util.Scanner;

/**
 * @author liupeidong
 * Created on 2019/4/9 14:48
 */
public class PrimeFactorization {

    private static int array[] = new int[10000];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(getCount(num));
    }

    private static int getCount(int num) {
        array[1] = 1;
        int sum = 1;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i != 0) {
                continue;
            }
            array[i] = find(i);
            sum += array[i];
        }
        return sum;
    }

    private static int find(int num) {
        if (array[num] != 0) {
            return array[num];
        }
        int sum = 1;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i != 0) {
                continue;
            }
            array[i] = find(i);
            sum += array[i];
        }
        return sum;
    }
}

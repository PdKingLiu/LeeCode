package algorithm_analysis;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author liupeidong
 * Created on 2019/4/9 15:07
 */
public class FullPermutation {

    private static int count = 0;

    private static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        char[] sum = num.toCharArray();
        perm(sum, 0, num.length() - 1);
        for (String s : set) {
            System.out.println(s);
        }
//        System.out.println(count);
    }

    private static void perm(char[] sum, int start, int end) {
        if (start == end) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i <= end; i++) {
                stringBuilder.append(sum[i]);
            }
            set.add(stringBuilder.toString());
            count++;
        } else {
            for (int i = start; i <= end; i++) {
                if (start == i || !(sum[start] == sum[i])) {
                    swap(sum, start, i);
                    perm(sum, start + 1, end);
                    swap(sum, start, i);
                }
            }
        }
    }

    private static void swap(char[] x, int a, int b) {
        char t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

}

package interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author liupeidong
 * Created on 2019/9/19 19:56
 */
public class _5 {

    static HashSet<Integer> list1 = new HashSet<>();
    static HashSet<Integer> list2 = new HashSet<>();
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>(n + 10);
        for (int i = 0; i < m; i++) {
            int a1 = scanner.nextInt();
            int a2 = scanner.nextInt();
            HashSet<Integer> set = map.get(a1);
            if (set == null) {
                set = new HashSet<>();
            }
            set.add(a1);
            set = map.get(a2);
            if (set == null) {
                set = new HashSet<>();
            }
            set.add(a1);
        }
        backtrack(0, n, map);
        System.out.println(max);
    }


    private static void backtrack(int i, int n, HashMap<Integer, HashSet<Integer>> map) {
        if (i == n) {
            int min = Math.min(list1.size(), list2.size());
            max = Math.max(min * 2, max);
            return;
        }
        HashSet<Integer> set = map.get(i);
        for (int j = 0; j < 2; j++) {
            if (j == 0) {
                if (!isContains(set, list1)) {
                    list1.add(i);
                    backtrack(i + 1, n, map);
                    list1.remove(i);
                }
            } else {
                if (!isContains(set, list2)) {
                    list2.add(i);
                    backtrack(i + 1, n, map);
                    list2.remove(i);

                }
            }
        }
    }

    private static boolean isContains(HashSet<Integer> set, HashSet<Integer> list1) {
        boolean isCon = false;
        if (set == null) {
            return isCon;
        }
        for (Integer ina : set) {
            if (list1.contains(ina)) {
                isCon = true;
                break;
            }
        }
        return isCon;
    }

}

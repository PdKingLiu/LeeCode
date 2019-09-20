package interview;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author liupeidong
 * Created on 2019/9/20 20:45
 */
public class _8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = n - 1; i >= 0; i--) {
            int end = i;
            int start;
            for (start = i - 1; start >= 0 && arr[start] == arr[i]; start--) {
            }
            if (end - 1 == start) {
                if (linkedList.size() > 1) {
                    int left = linkedList.getFirst();
                    int right = linkedList.getLast();
                    if (Math.abs(left - arr[i]) < Math.abs(right - arr[i])) {
                        linkedList.addLast(arr[i]);
                    } else {
                        linkedList.addFirst(arr[i]);
                    }
                } else {
                    linkedList.addLast(arr[i]);
                }
            } else {
                linkedList.addFirst(arr[i]);
                for (int j = 0; j < end - start - 1; j++) {
                    linkedList.addLast(arr[i]);
                }
                i = i - (end - start) + 1;
            }
        }
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(String.format("%d ", linkedList.get(i)));
        }
        System.out.println(linkedList.get(linkedList.size() - 1));
    }
}

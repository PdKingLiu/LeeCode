package competition_of_leecode;

import common.ListNode;

import java.util.Arrays;

/**
 * @author liupeidong
 * Created on 2019/8/25 11:23
 */
public class removeZeroSumSublists_5164 {

    public static ListNode removeZeroSumSublists(ListNode head) {
        int[] arr = new int[1002];
        int count = 0;
        while (head != null) {
            arr[count++] = head.val;
            head = head.next;
        }
        for (int i = 0; i < count; i++) {
            boolean isHave = false;
            for (int j = i; j < count; j++) {
                int sum = 0;
                boolean isFirst = true;
                for (int k = j; k < count; k++) {
                    if (arr[k] != 0) {
                        isFirst = false;
                    }
                    sum += arr[k];
                    if (sum == 0 && !isFirst) {
                        Arrays.fill(arr, j, k + 1, 0);
                        isHave = true;
                        break;
                    }
                }
            }
            if (!isHave) {
                break;
            }
        }
        ListNode listNode = new ListNode(-1);
        ListNode h = listNode;
        for (int i = 0; i < count; i++) {
            if (arr[i] != 0) {
                h.next = new ListNode(arr[i]);
                h = h.next;
            }
        }
        return listNode.next;
    }
}

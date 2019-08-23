package question;

import common.ListNode;

/**
 * @author liupeidong
 * Created on 2019/4/26 15:47
 */
public class Question_24_swapPairs {

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tem = head.next;
        head.next = swapPairs(head.next.next);
        tem.next = head;
        return tem;
    }
}

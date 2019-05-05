package question;

import common.ListNode;

/**
 * @author liupeidong
 * Created on 2019/4/25 23:48
 */
public class Question_21_mergeTwoLists {

    public static void main(String[] args) {
        ListNode listNode = ListNode.setList(new int[]{1, 3, 5, 6, 7});
        ListNode listNode2 = ListNode.setList(new int[]{2, 4, 5, 6, 9});
        ListNode.showList(mergeTwoLists(listNode, listNode2));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head;
        if (l1.val >= l2.val) {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        } else {
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        }
        return head;
    }
}
package question;

import common.ListNode;

/**
 * @author liupeidong
 * Created on 2019/4/17 10:13
 */
public class Question_19_RemoveNthFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (head.next == null && n == 1) {
            return null;
        }
        ListNode nN = new ListNode(n);
        List list = new List();
        delete(head, nN, list);
        if (nN.val == 0) {
            head = head.next;
        } else {
            list.listNode.next = list.listNode.next.next;
        }
        return head;
    }

    private static void delete(ListNode head, ListNode nN, List tem) {
        if (head.next != null) {
            delete(head.next, nN, tem);
        }
        if (nN.val != -1) {
            nN.val--;
        }
        if (nN.val == -1 && !tem.flag) {
            tem.flag = true;
            tem.listNode = head;
        }
    }

    private static class List {
        boolean flag = false;
        ListNode listNode;
    }
}

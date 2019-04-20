package question;

import common.ListNode;

import java.math.BigInteger;

/**
 * @author liupeidong
 * Created on 2019/4/17 10:13
 */
public class Question_19_RemoveNthFromEnd {

    public static void main(String[] args) {
        ListNode listNode = setUp(new BigInteger("1"));
        show(listNode);
        listNode = removeNthFromEnd(listNode, 1);
        System.out.println();
        show(listNode);
    }

    static class N {
        int n;

        N(int n) {
            this.n = n;
        }
    }

    static class List {
        boolean flag = false;
        ListNode listNode;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (head.next == null && n == 1) {
            return null;
        }
        N nN = new N(n);
        List list = new List();
        delete(head, nN, list);
        if (nN.n == 0) {
            head = head.next;
        } else {
            list.listNode.next = list.listNode.next.next;
        }
        return head;
    }

    private static void delete(ListNode head, N nN, List tem) {
        if (head.next != null) {
            delete(head.next, nN, tem);
        }
        if (nN.n != -1) {
            nN.n--;
        }
        if (nN.n == -1 && !tem.flag) {
            tem.flag = true;
            tem.listNode = head;
        }
    }

    public static void show(ListNode listNode) {
        while (listNode.next != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.print(listNode.val + " ");
    }

    public static ListNode setUp(BigInteger a) {
        ListNode listNode;
        ListNode tem;
        String string = a.toString();
        int anInt = Integer.parseInt(string.charAt(string.length() - 1) + "");
        listNode = new ListNode(anInt);
        listNode.next = null;
        tem = listNode;
        for (int i = string.length() - 2; i >= 0; i--) {
            int b = Integer.parseInt(string.charAt(i) + "");
            listNode.next = new ListNode(b);
            listNode = listNode.next;
            listNode.next = null;
        }
        return tem;
    }

}

package common;

import java.math.BigInteger;

/**
 * @author liupeidong
 * Created on 2019/4/19 11:39
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode() {
    }

    public static ListNode setList(int[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        ListNode listNode;
        ListNode tem;
        listNode = new ListNode(a[0]);
        listNode.next = null;
        tem = listNode;
        for (int i = 1; i < a.length; i++) {
            listNode.next = new ListNode(a[i]);
            listNode = listNode.next;
            listNode.next = null;
        }
        return tem;
    }

    public static void showList(ListNode listNode) {
        System.out.print("[");
        while (listNode.next != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println(listNode.val + "]");
    }
}

package question;

import common.ListNode;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * @author liupeidong
 * Created on 2019/4/2 19:51
 */
public class Question_2_AddTwoNumber {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger a = reversal(l1);
        BigInteger a2 = reversal(l2);
        return setUp(a.add(a2));
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

    public static BigInteger reversal(ListNode listNode) {
        ListNode tem;
        tem = listNode;
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return new BigInteger("0");
        }
        if (listNode.next == null) {
            return new BigInteger(listNode.val + "");
        } else {
            list.add(tem.val);
            while (tem.next != null) {
                tem = tem.next;
                list.add(tem.val);
            }
            StringBuilder stringBuffer = new StringBuilder();
            for (int i = list.size() - 1; i >= 0; i--) {
                int a = list.get(i);
                stringBuffer.append(a);
            }
            return new BigInteger(stringBuffer.toString());
        }
    }

}

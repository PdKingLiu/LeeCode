package question;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/11/6 17:16
 */
public class Question_25_reverseKGroup {

    /*给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

        k 是一个正整数，它的值小于或等于链表的长度。

        如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

        示例 :

        给定这个链表：1->2->3->4->5

        当 k = 2 时，应当返回: 2->1->4->3->5

        当 k = 3 时，应当返回: 3->2->1->4->5

        说明 :

        你的算法只能使用常数的额外空间。
        你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 */

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int count = 1;
        ListNode headTem = head;
        while (headTem.next != null) {
            count++;
            headTem = headTem.next;
        }
        if (count < k) {
            return head;
        }

        int countTem = 0;
        headTem = head;
        ListNode h = new ListNode(-1);
        ListNode f = h;
        while (countTem + k <= count) {
            ListNode front = null;
            ListNode frontTem = headTem;
            for (int i = 0; i < k; i++) {
                ListNode listNode = headTem.next;
                headTem.next = front;
                front = headTem;
                headTem = listNode;
            }
            f.next = front;
            f = frontTem;
            countTem += k;
        }
        f.next = headTem;
        return h.next;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int count = 1;
        ListNode headTem = head;
        while (headTem.next != null) {
            count++;
            headTem = headTem.next;
        }
        if (count < k) {
            return head;
        }
        headTem = head;
        ListNode h = new ListNode(-1);
        ListNode front = h;
        List<ListNode> list = new ArrayList<>(k + 5);
        int countTem = 0;
        for (int i = 0; i < count; i++) {
            if (countTem == 0 && i + k > count) {
                break;
            }
            list.add(headTem);
            countTem++;
            if (countTem == k) {
                headTem = headTem.next;
                for (int j = list.size() - 1; j > 0; j--) {
                    list.get(j).next = list.get(j - 1);
                }
                front.next = list.get(list.size() - 1);
                countTem = 0;
                front = list.get(0);
                list.clear();
                continue;
            }
            headTem = headTem.next;
        }
        front.next = headTem;
        return h.next;
    }

}

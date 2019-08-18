package question;

/**
 * @author liupeidong
 * Created on 2019/8/18 23:29
 */
public class Question_82_deleteDuplicates {

    /*给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

        示例 1:

        输入: 1->2->3->3->4->4->5
        输出: 1->2->5
        示例 2:

        输入: 1->1->1->2->3
        输出: 2->3 */

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temHead = new ListNode(-1);
        temHead.next = head;
        ListNode front = temHead;
        while (head.next != null) {
            if (head.next.val == head.val) {
                head.next = head.next.next;
                if (head.next != null) {
                    if (head.next.val != head.val) {
                        front.next = front.next.next;
                        head = front.next;
                    }
                } else {
                    front.next = null;
                    head = front;
                }
            } else {
                front = head;
                head = head.next;
            }
        }
        return temHead.next;
    }
}

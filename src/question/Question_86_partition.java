package question;

import common.ListNode;

/**
 * @author liupeidong
 * Created on 2019/8/20 15:34
 */
public class Question_86_partition {

    /*给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。

        你应当保留两个分区中每个节点的初始相对位置。

        示例:

        输入: head = 1->4->3->2->5->2, x = 3
        输出: 1->2->2->4->3->5 */

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode headTem = new ListNode(-1);
        ListNode headEnd = headTem;
        ListNode rearTem = new ListNode(-1);
        ListNode rearEnd = rearTem;
        while (head != null) {
            if (head.val < x) {
                headEnd.next = new ListNode(head.val);
                headEnd = headEnd.next;
            } else {
                rearEnd.next = new ListNode(head.val);
                rearEnd = rearEnd.next;
            }
            head = head.next;
        }
        headEnd.next = rearTem.next;
        return headTem.next;
    }
}

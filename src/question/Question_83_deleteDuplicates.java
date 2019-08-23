package question;

import common.ListNode;

/**
 * @author liupeidong
 * Created on 2019/8/18 23:14
 */
public class Question_83_deleteDuplicates {

    /*给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

        示例 1:

        输入: 1->1->2
        输出: 1->2
        示例 2:

        输入: 1->1->2->3->3
        输出: 1->2->3 */

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tem = head;
        while (head.next != null) {
            if (head.next.val == head.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return tem;
    }
}

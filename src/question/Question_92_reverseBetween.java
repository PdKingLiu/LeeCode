package question;

import common.ListNode;

/**
 * @author liupeidong
 * Created on 2019/10/2 10:41
 */
public class Question_92_reverseBetween {

    /*反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

        说明:
        1 ≤ m ≤ n ≤ 链表长度。

        示例:

        输入: 1->2->3->4->5->NULL, m = 2, n = 4
        输出: 1->4->3->2->5->NULL */

    /*
    * 线性遍历
    * 将头指向尾、尾指向头
    * 中间部分指向前一个
    * */

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode tem = new ListNode(-1);
        tem.next = head;
        m++;
        n++;
        ListNode headTem = tem;
        ListNode endTem = null;
        ListNode front = tem;
        ListNode t;
        for (int i = 2; i <= n; i++) {
            if (i < m) {
                headTem = head;
                t = head.next;
            } else if (i > m) {
                t = head.next;
                head.next = front;
            } else {
                endTem = head;
                t = head.next;
            }
            if (i == n) {
                headTem.next = head;
                endTem.next = t;
            }
            front = head;
            head = t;
        }
        return tem.next;
    }

}

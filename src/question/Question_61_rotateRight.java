package question;

/**
 * @author liupeidong
 * Created on 2019/8/9 8:41
 */
public class Question_61_rotateRight {

    /*给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

        示例 1:

        输入: 1->2->3->4->5->NULL, k = 2
        输出: 4->5->1->2->3->NULL
        解释:
        向右旋转 1 步: 5->1->2->3->4->NULL
        向右旋转 2 步: 4->5->1->2->3->NULL */

    ListNode front, end;
    int len = 1, lenTem = 1;
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        front = head;
        ListNode front = head;
        traverse(head, k);
        k = k % len;
        if (k == 0) {
            return head;
        } else {
            ListNode tem = getK(head, k);
            end.next = front;
            ListNode listNode = tem.next;
            tem.next = null;
            return listNode;
        }
    }


    public void traverse(ListNode head, int k) {
        if (head.next != null) {
            len++;
            traverse(head.next, k);
        } else {
            end = head;
        }
    }

    public ListNode getK(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (len - lenTem == k) {
            return head;
        } else {
            lenTem++;
            head = head.next;
            return getK(head, k);
        }
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
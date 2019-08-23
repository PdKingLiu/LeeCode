package common;

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

    public ListNode(int[] xs) {
        this.val = xs[0];
        ListNode tem = this;
        for (int i = 1; i < xs.length; i++) {
            tem.next = new ListNode(xs[i]);
            tem = tem.next;
        }
    }


    @Override
    public String toString() {
        ListNode tem = this;
        StringBuilder stringBuilder = new StringBuilder("[");
        while (tem.next != null) {
            stringBuilder.append(tem.val).append(", ");
            tem = tem.next;
        }
        stringBuilder.append(tem.val).append("]");
        return stringBuilder.toString();
    }
}

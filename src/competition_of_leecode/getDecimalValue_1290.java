package competition_of_leecode;

import common.ListNode;

/**
 * @author liupeidong
 * Created on 2020/1/13 0:00
 */
public class getDecimalValue_1290 {

    /*给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。

        请你返回该链表所表示数字的 十进制值 。

        示例 1：

        输入：head = [1,0,1]
        输出：5
        解释：二进制数 (101) 转化为十进制数 (5)
        示例 2：

        输入：head = [0]
        输出：0
        示例 3：

        输入：head = [1]
        输出：1
        示例 4：

        输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
        输出：18880
        示例 5：

        输入：head = [0,0]
        输出：0

        提示：

        链表不为空。
        链表的结点总数不超过 30。
        每个结点的值不是 0 就是 1。 */

    public int getDecimalValue(ListNode head) {
        if (head == null) {
            return 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (head != null) {
            stringBuilder.append(head.val);
            head = head.next;
        }
        int i;
        for (i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == '1') {
                break;
            }
        }
        stringBuilder = stringBuilder.delete(0, i);
        int sum = 0;
        for (int j = stringBuilder.length() - 1; j >= 0; j--) {
            if (stringBuilder.charAt(j) == '1') {
                sum += Math.pow(2, stringBuilder.length() - 1 - j);
            }
        }
        return sum;
    }

}

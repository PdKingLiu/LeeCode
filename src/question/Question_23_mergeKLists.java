package question;

import common.ListNode;

/**
 * @author liupeidong
 * Created on 2019/4/19 11:38
 */
public class Question_23_mergeKLists {

    public static void main(String[] args) {
        ListNode listNode = ListNode.setList(new int[]{1, 2, 3, 4, 5});
        ListNode listNode2 = ListNode.setList(new int[]{1, 2, 3, 4, 5});
        ListNode listNode3 = ListNode.setList(new int[]{5, 5, 6, 8, 13});
        ListNode listNode4 = ListNode.setList(new int[]{6, 7, 9, 10, 12});
        ListNode.showList(mergeKLists(new ListNode[]{}));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        if (lists.length == 2) {
            return mergeTwoList(lists[0], lists[1]);
        }
        int mid = lists.length / 2;
        ListNode[] leftLists = new ListNode[mid];
        ListNode[] rightLists = new ListNode[lists.length - mid];
        for (int i = 0; i < mid; i++) {
            leftLists[i] = lists[i];
        }
        for (int i = mid; i < lists.length; i++) {
            rightLists[i - mid] = lists[i];
        }
        return mergeTwoList(mergeKLists(leftLists), mergeKLists(rightLists));
    }

    private static ListNode mergeTwoList(ListNode leftList, ListNode rightList) {
        if (leftList == null) {
            return rightList;
        }
        if (rightList == null) {
            return leftList;
        }
        ListNode head = null;
        if (leftList.val < rightList.val) {
            head = leftList;
            head.next = mergeTwoList(leftList.next, rightList);
        } else {
            head = rightList;
            head.next = mergeTwoList(leftList, rightList.next);
        }
        return head;
    }

}

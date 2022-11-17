package leetcode.top100_01;

import leetcode.base.definition.ListNode;

public class T21_mergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode tail = head;
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    tail.next = new ListNode(list1.val);
                    tail = tail.next;
                    list1 = list1.next;
                } else {
                    tail.next = new ListNode(list2.val);
                    tail = tail.next;
                    list2 = list2.next;
                }
            } else {
                if (list1 != null) {
                    tail.next = new ListNode(list1.val);
                    tail = tail.next;
                    list1 = list1.next;
                }else{
                    tail.next = new ListNode(list2.val);
                    tail = tail.next;
                    list2 = list2.next;
                }
            }
        }
        return head.next;
    }
}

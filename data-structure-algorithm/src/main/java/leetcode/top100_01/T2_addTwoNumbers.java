package leetcode.top100_01;

import leetcode.base.definition.ListNode;

public class T2_addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n1 = 0, n2 = 0, carry = 0;
        ListNode result = new ListNode();
        ListNode head = result;
        while (l1 != null || l2 != null) {
            n1 = 0;
            n2 = 0;
            result.next = new ListNode();
            result = result.next;
            if (l1 != null) {
                n1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                n2 = l2.val;
                l2 = l2.next;
            }
            int value = n1 + n2 + carry;
            carry = value / 10;
            result.val = value % 10;
        }
        if (carry != 0) {//注意最后的进位
            result.next = new ListNode();
            result.next.val = carry;
        }
        return head.next;
    }

    public static void main(String[] args) {

    }
}

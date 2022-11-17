package leetcode.top100_01;

import leetcode.base.definition.ListNode;

public class T19_removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tag = new ListNode();
        tag.next = head;
        ListNode tail=tag;
        ListNode pre=tag;
        while(n>0){
            tail=tail.next;
            n--;
        }
        ListNode pre2=null;
        while(tail!=null){
            tail=tail.next;
            if(pre2==null){
                pre2=pre;
            }else{
                pre2 = pre2.next;
            }
            pre=pre.next;
        }
        pre2.next = pre2.next.next;
        return tag.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next=n2;
        n2.next=n3;
        ListNode listNode = new T19_removeNthFromEnd().removeNthFromEnd(n1, 3);
        System.out.println(listNode);
    }
}

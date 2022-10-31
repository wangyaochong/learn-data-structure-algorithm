package leetcode.top100_01;

import leetcode.base.definition.ListNode;
import java.util.Comparator;
import java.util.PriorityQueue;

public class T0023_x_mergeKLists {
    public static void main(String[] args) {
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head=new ListNode();
        ListNode tail = head;
        PriorityQueue<ListNode> queue= new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode node: lists) {
            if(node!=null){
                queue.add(node);
            }
        }
        while(queue.size()>0){
            ListNode poll = queue.poll();
            tail.next= poll;
            tail = tail.next;
            if(poll.next!=null){
                queue.add(poll.next);
            }
        }
        return head.next;
    }
}

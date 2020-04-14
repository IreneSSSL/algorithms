package easy.linkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SortList148 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(
                new Comparator<ListNode>(){
                    public int compare(ListNode a, ListNode b){
                        if (a.val > b.val) return 1;
                        if (a.val == b.val) return 0;
                        else return -1;
                    }
                });
        while (head != null){
            queue.add( head);
            head = head.next;
        }


        ListNode node = queue.poll();
        ListNode n =  node;
        while(!queue.isEmpty()){
            if (queue.peek()!=null){
                node.next = queue.poll();
                node = node.next;
            }
        }
        node.next = null;
        return n;
    }

}

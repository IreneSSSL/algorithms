package hard.linkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKsortedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }



//    the key point of this problem is using priority queue
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode l1, ListNode l2){
                if (l1.val < l2.val) return -1;
                else if (l1.val == l2.val) return 0;
                else return 1;
            }
        });
        for(ListNode node: lists){
            if(node !=null) queue.add(node);
        }
        ListNode head = new ListNode(1);
        ListNode node = head;
        while(!queue.isEmpty()){
            node.next = queue.poll();
            node = node.next;
            if (node.next != null) queue.add(node.next);

        }
        return head.next;
    }
}

package medium.LinkedList;

public class LinkedListCycle142 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(-4);
        a.next = b;
        b.next =c;
        c.next=d;
        d.next = b;

        new LinkedListCycle142().detectCycle(a);
    }

    public ListNode detectCycle(ListNode head) {
        if( head == null) return null;
        ListNode first = head;
        ListNode second = head;

        second = second.next;
        if (second == null) return null;
        second = second.next;
        if (second == null) return null;

        while (second !=null && first != second){
            first = first.next;
            second = second.next;
            if (second == null) return null;
            second = second.next;
        }
        if (second == null) return null;
        first = head;
        while (first != second){
            first = first.next;
            second = second.next;
        }
        return first;

    }
}

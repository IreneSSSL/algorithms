package easy.linkedList;

public class HasCycle141 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }



//    double pointers, one step 1 each time, the other step 2 each time
//    some boundary case
//   Second-Point reaches the end after the first step
//    one one or two nodes in this list
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }
        ListNode first = head;
        ListNode second = head.next.next;
        while (second != null) {
            if (first == second) {
                return true;
            }
            first = first.next;
            second = second.next;
            if (second == null) {
                return false;
            } else {
                second = second.next;
            }

        }
        return false;

    }
}

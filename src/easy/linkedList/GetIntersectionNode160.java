package easy.linkedList;

import medium.LinkedList.OddEvenList328;

public class GetIntersectionNode160 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }



//    marvellous idea of how to find the intersection node
//    we need to find the difference of these two lists' length, but it's a bad idea to traverse both.
//    length of start of A to the intersection : x
//    length of start of b to the intersection : y
//    length of the intersection to the end : z
//    we make each pointer move forward x+y+z steps, then we meet at the intersection.

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a != null ? a.next : headB;
            b = b != null ? b.next : headA;
        }
        return a;

    }
}

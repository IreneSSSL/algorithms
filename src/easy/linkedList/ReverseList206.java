package easy.linkedList;

public class ReverseList206 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

//    quite easy problem.
//    two pointers, back to back.
//    a temporary node, replacing the latter one that points at the rest of the linked list.
//    then reverse latter one and former one
//    former one -> latter one;
//    latter one -> temporary node.next;


    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode point = head;
        ListNode pnext = point.next;
        while (pnext != null) {
            ListNode tmp = new ListNode(pnext.val);
            tmp.next = pnext.next;
            pnext.next = point;
            point = pnext;
            pnext = tmp.next;
        }
        head.next = null;
        return point;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
//        ListNode c = new ListNode(3);
//        ListNode d = new ListNode(4);
//        a.next = b;
//        b.next =c;
//        c.next = d;
        b.next = null;
        new ReverseList206().reverseList(b);
    }
}

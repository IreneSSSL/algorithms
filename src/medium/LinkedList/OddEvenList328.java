package medium.LinkedList;

import medium.tree.IsValidBST98;

public class OddEvenList328 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }




//    EASY ONE
//    two pointers, one for odd and one for even. back to back
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode mid = head.next;
        ListNode f = head;
        ListNode s = mid;
        while (true) {
            if (s.next == null) break;
            f.next = s.next;
            if (f.next == null) break;
            f = f.next;
            if (f.next == null) break;
            s.next = f.next;
            if (s.next == null) break;
            s = s.next;
        }
        f.next = mid;
        s.next = null;
        return head;

    }
}

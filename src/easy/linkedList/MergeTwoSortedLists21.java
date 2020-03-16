package easy.linkedList;

public class MergeTwoSortedLists21 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }


    //    two pointers. head stays at the very begining of the final linked list. target moves forward.
//    compare l1 with l2, make target's next as the smaller one and move the smaller one's pointer forword.
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode head = null;
        ListNode target = null;
        if (l1.val <= l2.val) {
            target = l1;
            l1 = l1.next;
        } else {
            target = l2;
            l2 = l2.next;
        }
        head = target;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                target.next = l1;
                l1 = l1.next;
            } else {
                target.next = l2;
                l2 = l2.next;
            }
            target = target.next;
        }
        target.next = l1 == null ? l2 : l1;
        return head;
    }


}

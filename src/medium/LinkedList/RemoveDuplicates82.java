package medium.LinkedList;

public class RemoveDuplicates82 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode pre = new ListNode(head.val-1);
        pre.next = head;

        ListNode first = pre;
        ListNode second = head;

        ListNode result = pre;
        boolean deleted = false;
        while (second != null){
            while ( second.next !=null && second.val == second.next.val){
                second=second.next;
                deleted = true;
            }
            if(!deleted){
                first = first.next;
            }else {
                first.next = second.next;
            }
            second = second.next;
            deleted = false;


        }
        return pre.next;

    }
}

package easy.linkedList;

public class MiddleNode876 {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode middleNode(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next !=null){
            slow = slow.next;
            fast = fast.next;
            if (fast.next == null) return slow;
            fast = fast.next;
        }
        return slow;

    }

}

package easy.linkedList;

public class IsPalindrome234 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


//    recursively solve it
    ListNode ref = null;

    public boolean isPalindrome(ListNode head) {
        ref = head;
        return isCheck(head);

    }

    public boolean isCheck(ListNode head) {
        if (head == null) {
            return true;
        }
        boolean re = isCheck(head.next);
        boolean s = ref.val == head.val ? true : false;
        ref = ref.next;
        return s && re;
    }
}

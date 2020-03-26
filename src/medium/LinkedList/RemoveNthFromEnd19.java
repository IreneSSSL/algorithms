package medium.LinkedList;

public class RemoveNthFromEnd19 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

//    two pointers, with distance from each other N steps
//    three cases:
//    1 n < list length
//    2 n == list length, remove the first node
//    3 n > list length
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <=0){ return head;}
        ListNode first = head;
        ListNode second  = head ;
        int len = 0;
        for (int i=0;i<n && second != null; i++){
            second = second.next;
            len++;
        }
        if ( second == null){
            if (n == len){
                return head.next;  // case 2;
            }
            n = n % len;
            first = head;
            second  = head ;
            for (int i=0;i<n; i++){
                second = second.next;  // case 3
            }
        }

        // case 1
        second = second.next;
        while (second !=null){
            second = second.next;
            first = first.next;
        }
        first.next = first.next.next;
        return head;
    }

}

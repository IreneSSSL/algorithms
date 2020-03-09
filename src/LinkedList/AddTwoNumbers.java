package LinkedList;


class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
//        ListNode l2 = new ListNode(6);
//        ListNode l3 = new ListNode(6);
//        l1.next = l2;
//        l2.next = l3;

        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(8);
//        ListNode l6 = new ListNode(9);
        l4.next = l5;
//        l5.next = l6;
        ListNode re = new AddTwoNumbers().addTwoNumbers(l1,l4);

    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode result = head;
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        int extra = 0;
        while (l1 != null && l2 != null) {
            int v1 = l1.val;
            int v2 = l2.val;
            int unit = (v2 + v1 + extra) % 10;
            ListNode current = new ListNode(unit);
            head.next = current;
            head = head.next;
            extra = (v2 + v1 + extra) / 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode left = l1 == null ? l2 : l1;
        if (extra == 0) {
            head.next = left;
        } else {
            while (left != null) {
                int va = left.val;
                int unit = (va + extra) % 10;
                ListNode current = new ListNode(unit);
                head.next = current;
                head = head.next;
                extra = (va + extra) / 10;
                left = left.next;
            }
            if (extra == 1 ){
                ListNode last = new ListNode(1);
                last.next = null;
                head.next = last;
                head = head.next;
            }
            if (head.next != null) {
                head.next = null;
            }
        }

        return result.next;
    }


//    In this problem, we have to consider 2 traps.
//    1 sum of two digits is bigger than 10, then you have to add 1 to the next iteration;
//      it's a good idea to add an parameter, called extra in my alg, to the sum fixedly, if there is a carrying, extra = 1 or extra = 0;
//    2 two linked lists have different length, then you could just add parameter 'extra' with the left listnode directly.
//    Overall, the most challenging part of this problem is taking the carrying into consideration all the time.

//    cautions for myself
//    if (head.next == null) can't be in the outer of else.
//    sometimes pursuing code block globalization may induce extra error.

}

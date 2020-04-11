package hard.linkedList;

import medium.LinkedList.SwapNodesInPairs24;

public class ReverseNodeInKgroups25 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
//        ListNode g = new ListNode(7);
        a.next= b;
        b.next =c;
        c.next = d;
        d.next =e;
        e.next = f;
//        f.next=g;
        f.next = null;
        new ReverseNodeInKgroups25().reverseKGroup(a, 3);
    }



    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode node = new ListNode(1);
        node.next = head;

        ListNode tail = node.next;
        ListNode newHead = reverse(node.next,k-1);
        if (newHead == node.next) return head;
        head = newHead;
        node = tail;
        while (node !=null && node.next!=null ){
            tail = node.next;
            newHead = reverse(node.next,k-1);
            if (newHead == node.next) break;
            node.next =newHead;
            node = tail;
        }
        return head;

    }

    public ListNode reverse(ListNode node, int k){

        ListNode s = node;
        int len = k;
        while(s!=null && len-- >0){
            s = s.next;
        }
        if(len >=0) return node;


        ListNode former = node;
        ListNode later = node.next;
        while (former!=null && later!=null && k-- >0){
            ListNode tmp =later.next;
            later.next = former;
            former = later;
            later = tmp;
        }
//         this part means to reduce the check of K at the start of this function. but after testing, there is no significant increase. (both run in 0ms)
//        if (k >0){
//            ListNode h = former;
//            later = former.next;
//            int s = len-k;
//            while (former!=null && later!=null && s-- >0){
//                ListNode tmp =later.next;
//                later.next = former;
//                former = later;
//                later = tmp;
//            }
//            h.next = null;
//            return former;
//        }
        node.next = later;
        return former;
    }

}

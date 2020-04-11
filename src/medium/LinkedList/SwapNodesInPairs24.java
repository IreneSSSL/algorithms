package medium.LinkedList;

public class SwapNodesInPairs24 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


//    easy one
//    pass the node the swap function, then swap the two nodes next to this input node.
//    just need to take some extreme cases into consideration. like null, only one node, odd count nodes
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode tmp = new ListNode(1);
        tmp.next = head;
        ListNode result = tmp;

        while (true){
            swap(tmp);
            if (tmp == null || tmp.next == null || tmp.next.next == null) break;
            tmp = tmp.next.next;
        }
        return result.next;
    }

    public void swap(ListNode node){
        if (node == null || node.next == null || node.next.next == null ) return;
        ListNode a = node.next;
        ListNode b = a.next;
        node.next = b;
        a.next = b.next;
        b.next = a;
    }

}

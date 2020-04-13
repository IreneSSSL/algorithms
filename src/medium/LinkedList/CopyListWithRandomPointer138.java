package medium.LinkedList;

import java.util.HashMap;

public class CopyListWithRandomPointer138 {
    public class Node {
        int val;
        Node next;
        Node random;
        Node(int x) {
            val = x;
        }
    }


    public Node copyRandomList(Node head) {
        if (head == null) return null;

        HashMap<Node,Node> map = new HashMap<>();
        Node start = head;
        while(start != null){
            Node node = new Node(start.val);
            map.put(start, node);
            start = start.next;
        }

        start = head;
        while (start != null){
            Node node = map.get(start);
            node.next = map.get(start.next);
            node.random = map.get(start.random);
            start = start.next;
        }
        return map.get(head);
    }
}

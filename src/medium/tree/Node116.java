package medium.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Node116 {
    public int val;
    public Node116 left;
    public Node116 right;
    public Node116 next;

    public Node116() {}

    public Node116(int _val) {
        val = _val;
    }

    public static void main(String[] args) {
        Node116 a = new Node116(1);
        Node116 b = new Node116(2);
        Node116 c = new Node116(3);
        Node116 d = new Node116(4);
        Node116 e = new Node116(5);
        Node116 f = new Node116(6);
        Node116 g = new Node116(7);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left=f;
        c.right=g;
        new Node116().connect2(a);

    }
//  this is the fastest way
    public Node116 connect2(Node116 root) {
        if(root==null || (root.left == null && root.right==null)) return root;
        if(root.next != null) root.right.next = root.next.left;
        root.left.next = root.right;
        connect2(root.left);
        connect2(root.right);
        return root;

    }



//    this is my solution. 'next' always points to the next traversed node in level traversal.
    public Node116(int _val, Node116 _left, Node116 _right, Node116 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public Node116 connect(Node116 root) {
        if(root ==null) return null;
        Queue<Node116> queue = new LinkedList<Node116>();
        queue.add(root);
        while( !queue.isEmpty()){
            Node116 node = queue.poll();
            node.next = queue.isEmpty() ? null : queue.peek();
            if (node!=null && node.left !=null){
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        changeRightest(root);
        return root;
    }

    public void changeRightest(Node116 root){
        Stack<Node116> stack = new Stack<Node116>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node116 node = stack.pop();
            if(node ==null) continue;
            node.next = null;
            node = node.right;
            stack.push(node);
        }
    }
}

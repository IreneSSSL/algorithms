package medium.tree;

public class PopulatingNextRightPointersinEachNode117 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    private Node leftmost, prev, curr;
    public Node connect(Node root) {
        this.leftmost = root;
        while (this.leftmost != null) {
            this.prev = null;
            curr = this.leftmost;
            this.leftmost = null;

            while (curr != null) {
                this.processChild(curr.left);
                this.processChild(curr.right);
                curr = curr.next;
            }
        }
        return root;
    }

    private void processChild(Node childNode) {
        if (childNode == null) {
            return;
        }
        if (this.prev != null) {
            this.prev.next = childNode;
        } else {
            this.leftmost = childNode;
        }
        this.prev = childNode;
    }
}

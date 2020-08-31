package medium.tree;

import easy.tree.ConvertTree226;

public class ConvertSortedListToBST109 {

    public static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(0);
        ListNode one1 = new ListNode(1);
        ListNode one2 = new ListNode(2);
        ListNode one3 = new ListNode(3);
        ListNode one4 = new ListNode(4);
        ListNode one5 = new ListNode(5);
        one.next = one1;
        one1.next=one2;
        one2.next=one3;
        one3.next=one4;
        one4.next = one5;
        one5.next = null;
        TreeNode nod = new ConvertSortedListToBST109().sortedListToBST(one);
        System.out.println(nod.val);
    }
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
//        if only two nodes, the first one is smaller, make it as the root and make the second one as it's right child
        if (head.next.next == null) {
            TreeNode a = new TreeNode(head.val);
            TreeNode b = new TreeNode(head.next.val);
            a.right = b;
            return a;
        }

        ListNode first = head;
        ListNode second = head;
        ListNode pre = new ListNode();
        pre.next = first;
//        find the middle one, make it as the root node
        while (second.next != null) {
            second = second.next;
            first = first.next;
            pre = pre.next;
            if (second.next == null) break;
            second = second.next;
        }


        TreeNode root = new TreeNode(first.val);
//        the right part of the list constitutes the right subtree of the root
        root.right = sortedListToBST(first.next);
//        make the node's next is null which is before the middle, and the left part of the list constitutes the left subtree of the root
        pre.next = null;
        root.left = sortedListToBST(head);
        return root;
    }

}

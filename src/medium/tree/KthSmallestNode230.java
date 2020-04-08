package medium.tree;

import java.util.LinkedList;
import java.util.Stack;

public class KthSmallestNode230 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(2);
//        Node116 e = new Node116(5);
//        Node116 f = new Node116(6);
//        Node116 g = new Node116(7);
        a.left = b;
        a.right = c;
        b.right = d;
//        b.right = e;
//        c.left=f;
//        c.right=g;
        new KthSmallestNode230().kthSmallest( a, 3);

    }


    public int kthSmallest(TreeNode root, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while( list.size()!=k ){
            while(root !=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root == null) continue;
            list.add(root.val);
//            stack.push(root.right);  Cant push right node into stack here, cause it will be push double times.
            root = root.right;
        }
        return list.getLast();
    }
}

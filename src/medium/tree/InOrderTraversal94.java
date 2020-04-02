package medium.tree;

import java.util.*;

public class InOrderTraversal94 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        List<Integer> a = new LinkedList<>();
        List<Integer> b = new LinkedList<>();
        a.add(0);
        a.add(1);
        a.add(1);
        a.add(2);
        b.add(1);
        b.add(1);
        b.add(1);
        System.out.println(a.containsAll(b));

    }

   //    this is solved recursively
    public List<Integer> inorderTraversal(TreeNode root) {
        return check(root);
    }

    public List<Integer> check(TreeNode root){
        if(root == null) return new ArrayList<>();
        List<Integer> re = new ArrayList<>();
        if ( root.left == null && root.right == null) {
            re.add(root.val);
            return re;
        }
        re.addAll( check(root.left));
        re.add(root.val);
        re.addAll( check(root.right));
        return re;
    }


//    this is solved iteratively
    public List < Integer > inorderTraversal2(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        Stack < TreeNode > stack = new Stack< >();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}

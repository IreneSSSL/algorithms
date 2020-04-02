package medium.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal94 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
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

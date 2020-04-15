package medium.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LowestCommonAncestorOfBinaryTree236 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

//    recursive solution
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else {
            return left == null ? right : left;
        }

    }


//    this solution is slower, recursive solution is a better idea.
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if (root.left == null && root.right == null) return null;
        HashMap<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        map.put(root, null);

        int cnt = 0;
        if (root.val == q.val || root.val == p.val) cnt++;
        TreeNode a = root;
        TreeNode b = root;

        while( !stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node == null) continue;
            if (node.right != null){
                if (node.right.val == p.val || node.right.val == q.val){
                    cnt++;
                    if (cnt ==1) a = node.right;
                    else b = node.right;
                }
                stack.add(node.right);
                map.put(node.right, node);
                if (cnt == 2){
                    break;
                }
            }
            if (node.left != null){
                if (node.left.val == p.val || node.left.val == q.val){
                    cnt++;
                    if (cnt ==1) a = node.left;
                    else b =node.left;
                }
                stack.add(node.left);
                map.put(node.left, node);
                if (cnt == 2){
                    break;
                }
            }
        }

        if (cnt != 2){
            return null;
        }

        Set<TreeNode> set = new HashSet<TreeNode>();
        TreeNode parent = a;
        set.add(parent);
        while (parent != null){
            TreeNode node =  map.get(parent);
            set.add(node);
            parent = node;
        }
        parent = map.get(b);
        while (parent!=null && !set.contains(parent)){
            parent = map.get(parent);
        }
        if (parent == null){
            return root;
        } else {
            return parent;
        }
    }
}

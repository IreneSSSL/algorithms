package medium.tree;

import java.util.Stack;

public class FlatenBinaryTree114 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public void flatten(TreeNode root) {
        if (root == null ) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node == null) continue;
            if (node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
            if ( !stack.isEmpty() ){
                node.right = stack.peek();
                node.left = null;
            }
        }
        return;

    }
}

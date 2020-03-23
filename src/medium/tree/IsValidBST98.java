package medium.tree;

import java.util.Stack;

public class IsValidBST98 {

    public static void main(String[] args) {
        double inorder = -Integer.MAX_VALUE;
        System.out.println( -2147483648 < inorder);
    }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }



//    in-order traversal. but this is not enough
//    here are some tips
//    1 lower bound of double is larger than 0;
//    2 an int value could be allocated to a double type variable
//    3 right side node value is larger or equal to the root node
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        double inorder = -Double.MAX_VALUE;
        while( !stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}

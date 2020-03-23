package easy.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class maxDepth104 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


//    this one is best
    public int maxDepthBest(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }


//    this one uses pre-order search
    public int maxDepth(TreeNode root) {
        int depth = 1;
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        map.put(root, 1);
        stack.push(root);
        TreeNode last = root;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.left != null) {
                    stack.push(node.left);
                    map.put(node.left, map.get(node) + 1);
                    depth = Math.max(depth, map.get(node) + 1);
                }
                if (node.right != null) {
                    stack.push(node.right);
                    map.put(node.right, map.get(node) + 1);
                    depth = Math.max(depth, map.get(node) + 1);
                }
            }
        }
        return depth;
    }
}

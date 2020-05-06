package hard.tree;

import easy.tree.ConvertTree226;

public class BinaryTreeMaximumPathSum124 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        helper(root);
        return max;
    }

    public int helper(TreeNode root){
        int left = root.left != null ? Math.max(0,helper(root.left) ): 0;
        int right = root.right != null ? Math.max(0,helper(root.right) ): 0;
        max = Math.max(max, left + right + root.val);
        return Math.max(0, Math.max(left, right)) + root.val;
    }

}

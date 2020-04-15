package medium.tree;

public class HouseRobber3_337 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

//    recursive solution
    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null){
            return root.val;
        }
        int[] result = helper(root);
        if (result[0] > result[1]) return result[0];
        return result[1];

    }

    public int[] helper(TreeNode root){
        int[] result = new int[2];
        if (root == null ) return result;
        if (root.left == null && root.right == null){
            result[0] = root.val;
            result[1] = 0;
            return result;
        }

        int[] right = helper(root.right); // right[0] 当前节点偷的情况下，最大收益；right[1] 当前节点不偷的情况下，最大收益
        int[] left = helper(root.left);
        result[0] = root.val + right[1]+left[1];
        result[1] = Math.max(right[1], right[0]) + Math.max(left[1], left[0]);
        return result;
    }

}

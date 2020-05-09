package medium.tree;

public class PreOrderReconstructTree1008 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) return null;
        return helper(preorder, 0, preorder.length-1);
    }

    public TreeNode helper(int[] preorder, int start, int end){
        if (start > end) return null;
        TreeNode root = new TreeNode(preorder[start]);
        if (start == end) return root;
        int mid = start;
        while (++mid <= end && preorder[mid] < preorder[start]);
        root.left = helper(preorder, start+1, mid-1);
        root.right = helper(preorder,mid, end);
        return root;
    }

}

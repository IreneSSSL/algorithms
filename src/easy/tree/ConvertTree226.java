package easy.tree;

public class ConvertTree226 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }




//    iterative swap left and right node
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        if(root.left == null && root.right == null) return root;
        TreeNode right = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(right);
        return root;
    }
}

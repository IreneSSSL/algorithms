package medium.dfs;

import medium.tree.BinaryTreeLevelOrderTraversal102;

public class RecoverTreeFromPostAndInorderTraversal106 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        int[] in = {2,3,1};
         int[] post = {3,2,1};
         TreeNode rott = new RecoverTreeFromPostAndInorderTraversal106().buildTree(in, post);
        System.out.println(rott.val);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || inorder.length!= postorder.length) return null;
        return helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    public TreeNode helper(int[] inorder, int start1,int end1,int[] postorder, int start2, int end2){
        TreeNode root = new TreeNode(postorder[end2]);
        if(start1 == end1) return root;
        int middle = start1;
        for (int i = start1;i<=end1;i++){
            if(inorder[i] == postorder[end2] ) {
                middle = i-1;
                break;
            }
        }
        int middle2 = start2+ (middle-start1);
        if (start1<=middle){
            root.left = helper(inorder, start1,middle, postorder, start2,middle2);
        }
        if (middle+2 <= end1){
            root.right = helper(inorder, middle+2, end1, postorder,middle2+1, end2-1);
        }


        return root;
    }

}

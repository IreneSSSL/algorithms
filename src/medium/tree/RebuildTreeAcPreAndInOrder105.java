package medium.tree;

public class RebuildTreeAcPreAndInOrder105 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int preIndex;
    int inIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        inIndex = 0;
        return helper(inorder, preorder, Integer.MAX_VALUE);
    }

//
    private TreeNode helper(int[] inOrder, int[] preOrder, int target) {
        if (inIndex >= inOrder.length || inOrder[inIndex] == target) {
            return null;
        }

        TreeNode root = new TreeNode(preOrder[preIndex]);
        preIndex++;
        root.left = helper(inOrder, preOrder, root.val);
        inIndex++;
        root.right = helper(inOrder, preOrder, target);
        return root;
    }



//    this is what I used, not smart enough
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return null;
        return check(preorder,0, preorder.length-1, inorder,0, inorder.length-1);
    }

    public TreeNode check(int[] preorder, int preS, int preE, int[] inorder, int inS,int inE){
        if(preS > preE || inS> inE){
            return null;
        }
        for (int j= inS;j<=inE; j++){
            if(preorder[preS] == inorder[j]){
                TreeNode node = new TreeNode(inorder[j]);
                node.left = check(preorder, preS+1,  j - inS + preS, inorder, inS, j-1);
                node.right = check(preorder,  j - inS + preS+1, preE, inorder,j+1,inE);
                return node;
            }
        }

        return null;

    }

}

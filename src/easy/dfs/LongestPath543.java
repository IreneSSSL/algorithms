package easy.dfs;

import easy.tree.ConvertTree226;

public class LongestPath543 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    int ans = 1;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return ans-1;
    }

//    计算最深的那个路径长度，并存储。然后通过递归，实现对树的遍历。
    public int helper(TreeNode node){
        if(node == null) return 0;
        int L = helper(node.left);
        int R = helper(node.right);
        ans = Math.max(ans, L+R+1);
        return Math.max(L,R) +1;
    }
}

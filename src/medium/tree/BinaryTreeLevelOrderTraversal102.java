package medium.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal102 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


//  REMEMBER, this is level-order traversal, after traversing all the n-1 level node, all the n level nodes are in the queue
//    that means the queue's size = the node numbers from n level
//    so even we have to add n+1 level nodes into queue when traversing n level node, we still know when to stop
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new LinkedList<Integer>();
            for(int i =0;i<size;i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
            }
            res.add(list);
        }
        return res;
    }
}

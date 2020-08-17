package medium.tree;

import easy.array.BinarySearch744;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree95 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        new BinarySearchTree95().generateTrees(3);
    }
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<TreeNode>();

        HashMap<Integer, List<TreeNode>> index = new HashMap<>();
        List<TreeNode> one = new LinkedList<>();
        one.add(new TreeNode(1));
        index.put(1, one);
        index.put(0, null);

        for (int i=2;i<=n ;i++){
            for (int root=1;root<=i;root++){
                List<TreeNode> lefts = index.get(root-1);
                List<TreeNode> rights = index.get(i-root);
                if (lefts == null) {
                    for(TreeNode right:rights){
                        TreeNode r = new TreeNode(root);
                        r.left = null;
                        r.right = clone(right, root);
                        List<TreeNode> list = index.getOrDefault(i, new LinkedList<TreeNode>());
                        list.add(r);
                        index.put(i, list);
                    }
                }else if (rights == null){
                    for (TreeNode left: lefts ){
                        TreeNode r = new TreeNode(root);
                        r.left = clone(left, 0);
                        r.right = null;
                        List<TreeNode> list = index.getOrDefault(i, new LinkedList<TreeNode>());
                        list.add(r);
                        index.put(i, list);
                    }
                } else{
                    for (TreeNode left: lefts ){
                        for(TreeNode right:rights){
                            TreeNode r = new TreeNode(root);
                            r.left = left;
                            r.right = clone(right, root);
                            List<TreeNode> list = index.getOrDefault(i, new LinkedList<TreeNode>());
                            list.add(r);
                            index.put(i, list);
                        }
                    }
                }

            }
        }
        return index.get(n);

    }

    public static TreeNode clone(TreeNode root , int offsite){
        if (root == null) return root;
        TreeNode clo = new TreeNode(root.val + offsite);
        clo.left = clone(root.left, offsite);
        clo.right = clone(root.right, offsite);
        return clo;
    }
}

package easy.tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths257 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<String> result = new LinkedList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return result;

        LinkedList<Integer> list = new LinkedList<>();
        list.add(root.val);
        helper(root, list);
        return result;
    }

    public void helper(TreeNode node, LinkedList<Integer> list){
        if (node.right == null && node.left==null){
            generateStr(list);
            return;
        }
        if (node.left !=null){
            list.add(node.left.val);
            helper(node.left, list);
            list.removeLast();
        }
        if(node.right != null){
            list.add(node.right.val);
            helper(node.right, list);
            list.removeLast();
        }
    }

    public void generateStr(List<Integer> list){
        if (list.size() == 1){
            String s = list.get(0).toString();
            result.add(s);
            return;
        }else{
            String s = "";
            for(int i=0;i<list.size();i++){
                s = s+list.get(i)+"->";
            }
            result.add(s.substring(0,s.length()-2));
            return;
        }
    }
}

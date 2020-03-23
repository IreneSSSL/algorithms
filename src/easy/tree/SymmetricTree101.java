package easy.tree;

import java.lang.reflect.Array;
import java.util.*;

public class SymmetricTree101 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 1;
        System.out.println( a ==null ^ b==null);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        HashMap<Integer, ArrayList<Integer>> result = new HashMap<Integer, ArrayList<Integer>>();
        stack.push(root);
        HashMap<TreeNode, Integer> map = new HashMap<>();
        ArrayList<Integer> first = new ArrayList<Integer>();
        first.add(root.val);
        result.put(1, first);
        map.put(root, 1);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                continue;
            }
            int depth = map.get(node);
            ArrayList<Integer> levelNodeList = result.get(depth + 1) == null ? new ArrayList<>() : result.get(depth + 1);
            if (node.left != null) {
                stack.push(node.left);
                map.put(node.left, depth + 1);
                levelNodeList.add(node.left.val);
            } else {
                levelNodeList.add(null);
            }
            if (node.right != null) {
                stack.push(node.right);
                map.put(node.right, depth + 1);
                levelNodeList.add(node.right.val);
            } else {
                levelNodeList.add(null);
            }
            result.put(depth + 1, levelNodeList);
        }
        for (int dep : result.keySet()){
            ArrayList<Integer> levelNodeList = result.get(dep);
            if (levelNodeList.isEmpty()){
                break;
            }
            int size = levelNodeList.size();
            int start = 0;
            int end = size -1;
            while(start < end){
                Integer s = levelNodeList.get(start++);
                Integer e = levelNodeList.get(end--);
                if ( s== null ^ e==null){
                    return false;
                }
                if ( (s==null && e == null) || s.equals(e)) continue;
                else return false;
            }
        }
        return true;
    }


//    this one is faster
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(root);
        while(!q.isEmpty()){
            TreeNode n1 = q.poll();
            TreeNode n2 = q.poll();
            if (n1 == null ^ n2 == null) return false;
            if (n1 == null && n2 == null ) continue;
            if (n1.val == n2.val){
                q.add(n1.left);
                q.add(n2.right);
                q.add(n2.right);
                q.add(n1.left);
            } else {
                return false;
            }
        }
        return true;
    }


//  this one is the fastest
    public boolean isSymmetric3(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }
}

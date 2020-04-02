package medium.tree;

import java.util.*;

public class ZigZagLevelOrder103 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        for (int i=1;i<0;i++){
            System.out.println(i);
        }
    }


//    this is what I did. beat 68.16% with 2ms
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new LinkedList<List<Integer>>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Map<TreeNode, Integer> node2Level = new HashMap<>();
        Map<Integer, List<Integer>> level2Value = new HashMap<>();

        List<Integer> first = new LinkedList<>();
        first.add(root.val);
        level2Value.put(1,first);
        stack.push(root);
        node2Level.put(root, 1);
        int depth = 1;
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node == null) continue;
            TreeNode left = node.left;
            TreeNode right = node.right;
            int level = node2Level.get(node) +1;
            List<Integer> values = level2Value.get(level) == null ? new LinkedList<Integer>() :level2Value.get(level);
            stack.push(right);  // always push right before left
            if (left != null){
                node2Level.put(left, level);
                values. add (left.val);
                depth = Math.max(depth, level);
                stack.push(left);
            }
            if (right != null){
                node2Level.put(right, level);
                values.add(right.val);
                depth = Math.max(depth, level);

            }
            level2Value.put(level, values);
        }
        List<List<Integer>> result =  new LinkedList<List<Integer>>();
        for (int i=1;i<= depth;i++){
            List<Integer> list = new LinkedList<>();
            list.addAll(level2Value.get(i));
            if (i%2 == 0){
                Collections.reverse(list);
            }
            result.add(list);
        }
        return result;

    }

//    this is the smart solution.
//    level order traversal should use queue, instead of stack
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            level += 1;
            LinkedList<Integer> list = new LinkedList<Integer>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(level % 2 != 0){
                    list.add(node.val);
                } else {
                    list.addFirst(node.val);
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            result.add(list);
        }

        return result;
    }
}

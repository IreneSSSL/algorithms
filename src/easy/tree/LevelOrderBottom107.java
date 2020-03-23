package easy.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class LevelOrderBottom107 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }



//    using other data structures to store extra information
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        HashMap<Integer, ArrayList<Integer>> result = new HashMap<Integer, ArrayList<Integer>>();
        ArrayList<Integer> first = new ArrayList<Integer>();
        first.add(root.val);
        result.put(1, first);

        HashMap<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 1);


        int dept = 1;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                continue;
            }
            int depth = map.get(node);
            ArrayList<Integer> levelNodeList = result.get(depth + 1) == null ? new ArrayList<>() : result.get(depth + 1);
            if (node.left != null) {

                map.put(node.left, depth + 1);
                levelNodeList.add(node.left.val);
            }
            if (node.right != null) {

                map.put(node.right, depth + 1);
                levelNodeList.add(node.right.val);
            }
            stack.push(node.right);
            stack.push(node.left);
            dept = Math.max(dept, depth + 1);
            result.put(depth + 1, levelNodeList);
        }
        List<List<Integer>> re = new ArrayList<List<Integer>>();
        for (int i = dept; i > 0; i--) {
            ArrayList<Integer> levelNodeList = result.get(i);
            if (levelNodeList.isEmpty()) {
                continue;
            }
            re.add(levelNodeList);

        }
        return re;
    }

}

package hard.tree;

import java.lang.reflect.Array;
import java.util.*;

public class Codec297 {

    public static void main(String[] args) {
        String s = " a  b ";
        String[] ss = s.split(" ");
        System.out.println( ss.length);

    }

//    public static void main(String[] args) {
//        TreeNode t0 = new TreeNode(0);
//        TreeNode t1 = new TreeNode(1);
//        TreeNode t2 = new TreeNode(2);
//        TreeNode t3 = new TreeNode(3);
//        TreeNode t4 = new TreeNode(4);
//        TreeNode t5 = new TreeNode(5);
////        t0.left=t1;
////        t0.right = t2;
////        t1.left=t3;
////        t1.right=t4;
////        t2.right = t5;
////        int height = new Codec297().height(t0);
////        System.out.println(height);
//
//        String s = new Codec297().serialize(t0);
//        System.out.println(s);
//        TreeNode t = new Codec297().deserialize(s);
//        System.out.println(t.val);
//    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int height(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int left = height(root.left) + 1;
        int right = height(root.right) + 1;
        return Math.max(left, right);
    }

    public String serialize(TreeNode root) {
        if (root == null) return "";
        if (root.left == null && root.right == null) return String.valueOf(root.val);

        int height = height(root);
        Integer[] array = new Integer[2 * height + 1];

        HashMap<TreeNode, Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        map.put(root, 0);
        array[0] = root.val;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int index = map.get(node);
                TreeNode left = node.left;
                TreeNode right = node.right;
                if (left != null) {
                    map.put(left, index * 2 + 1);
                    queue.add(left);
                    array[index*2+1] = left.val;
                }
                if (right != null) {
                    map.put(right, index * 2 + 2);
                    queue.add(right);
                    array[index*2+2] =right.val;
                }
            }
        }
        StringBuilder sb = new StringBuilder("");
        for (Integer i : array){
            if (i == null){
                sb.append("a,");
            }else{
                sb.append(i.toString()+",");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
//        char[] array = data.toCharArray();
        String[] strings = data.split(",");
        Map<Integer, TreeNode> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            String c = strings[i];
            if (c.equals("a")) {
                map.put(i, null);
            } else {
                int m = Integer.parseInt(c);
                TreeNode node = new TreeNode( m );
                map.put(i, node);
            }
        }
        TreeNode node = null;
        for (int i = 0; i < strings.length / 2; i++) {
            TreeNode left = map.get(2 * i + 1);
            TreeNode right = map.get(2 * i + 2);
            node = map.get(i);
            if (node == null) continue;
            node.left = left;
            node.right = right;
        }
        return map.get(0);


    }

}

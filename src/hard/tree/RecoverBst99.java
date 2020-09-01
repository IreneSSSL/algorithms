package hard.tree;

import java.util.HashMap;

public class RecoverBst99 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);

        t3.right = t4;
        t3.left = t1;
        t4.left = t2;
        new RecoverBst99().recoverTree(t3);
    }

    public void recoverTree(TreeNode root) {
        if (root == null) return;
        TreeNode b = findMin(root.right);
        TreeNode a = findMax(root.left);
        if (a == null && b == null) return;

        if (a != null && b != null && a.val <= root.val && root.val <= b.val) {
            recoverTree(root.left);
            recoverTree(root.right);
            return;
        }

        if (a != null && b != null && a.val >= root.val && root.val >= b.val) {
            int tmp = a.val;
            a.val = b.val;
            b.val = tmp;
            return;
        }

        if (a != null && a.val > root.val) {
            int tmp = a.val;
            a.val = root.val;
            root.val = tmp;
            return;
        }
        if (b != null && b.val < root.val) {
            int tmp = b.val;
            b.val = root.val;
            root.val = tmp;
            return;
        }

        if (a != null && a.val < root.val) {
            recoverTree(root.left);
            return;
        }
        if (b != null && b.val > root.val) {
            recoverTree(root.right);
            return;
        }


    }

    public TreeNode findMin(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        int min = root.val;
        TreeNode left = findMin(root.left);
        TreeNode right = findMin(root.right);

        if (left != null) {
            root = root.val > left.val ? left : root;
        }
        if (right != null) {
            root = root.val > right.val ? right : root;
        }
        return root;
    }

    public TreeNode findMax(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        int max = root.val;
        TreeNode left = findMax(root.left);
        TreeNode right = findMax(root.right);


        if (left != null) {
            root = root.val < left.val ? left : root;
        }
        if (right != null) {
            root = root.val < right.val ? right : root;
        }
        return root;
    }
}

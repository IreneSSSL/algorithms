package easy.tree;

public class SortedArrayToBst108 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int[] n = new int[]{0,1,2,3};
        new SortedArrayToBst108().sortedArrayToBST(n);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0){
            return null;
        }
        if (nums.length ==1){
            return new TreeNode(nums[0]);
        }
        return helper(nums,0, nums.length);

    }

//  recursive
    public TreeNode helper(int[] nums, int low,int high){
        if (low >= high){
            return null;
        }
        TreeNode root = new TreeNode(nums[(low+high)/2]);
        root.left = helper(nums,low, (low+high)/2);
        root.right = helper(nums, (low+high)/2 +1 , high);
        return root;
    }

}

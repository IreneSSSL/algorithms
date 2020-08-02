package medium.segmenttree;

public class RangeSumQuery307 {


    public static void main(String[] args) {
        int[] a = {2,4,5,7,8,9};
        new RangeSumQuery307(a);
    }
    int[] tree;
    int n;
    public RangeSumQuery307(int[] nums) {
        if (nums.length > 0) {
            n = nums.length;
            tree = new int[n * 2];
            buildTree(nums);
        }
    }
    private void buildTree(int[] nums) {
        for (int i = n, j = 0;  i < 2 * n; i++,  j++)
            tree[i] = nums[j];
        for (int i = n - 1; i > 0; --i)
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
    }
}

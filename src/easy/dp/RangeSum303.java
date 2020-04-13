package easy.dp;

public class RangeSum303 {

    int[] dp;
    int[] rep;
    // dp[2]  0+1+2
    // dp[5]  0+1+2+3+4+5
    // INPUT: 2,5   2+3+4+5

    public RangeSum303(int[] nums) {
        rep = nums;
        if(nums.length == 0){
            dp = new int[]{0}; return;
        }
        dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i=1;i< nums.length;i++){
            dp[i] = dp[i-1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (j >= rep.length ) j = rep.length-1;
        if (i <0 ) i = 0;
        if (i == 0) return dp[j];
        return dp[j] -dp[i-1];
    }

    /**
     * Your RangeSum303 object will be instantiated and called as such:
     * RangeSum303 obj = new RangeSum303(nums);
     * int param_1 = obj.sumRange(i,j);
     */

}

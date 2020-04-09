package medium.dp;

public class LongestIncreasingSubsequence300 {


    public static void main(String[] args) {
        int[] a ={10,9,2,5,3,7,101,18};
        new LongestIncreasingSubsequence300().lengthOfLIS(a);
    }
    public int lengthOfLIS(int[] nums) {
        int max = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i=1;i< nums.length;i++){
            if (nums[i] < nums[i-1]) dp[i] = 1;
            int closest = nums.length;
            for (int j=i-1; j>=0; j--){
                if (nums[j]> nums[i]) continue;
                if (closest == nums.length) closest = j;
                else if(dp[closest] < dp[j]){
                    closest = j;
                }
            }
            if ( closest != nums.length && nums[i] > nums[closest]){
                dp[i] = dp[closest]+1;
                max = Math.max(max,dp[i]);
            }
        }
        return max;
    }
}

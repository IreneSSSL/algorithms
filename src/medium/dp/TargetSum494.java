package medium.dp;

public class TargetSum494 {


    //    dp
    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) return 0;
        return helper(nums, nums.length - 1, S);
    }

    public int helper(int[] nums, int end, int S) {
        if (end == 0) {
            if (S == 0 && nums[0] == 0) {
                return 2;
            } else if (S == nums[0] || S == -nums[0]) {
                return 1;
            } else {
                return 0;
            }
        }
        return helper(nums, end - 1, S - nums[end]) + helper(nums, end - 1, S + nums[end]);
    }


    //  二维数组的dp，第二维代表的是nums（某种情况下的）的和
    public int findTargetSumWays2(int[] nums, int S) {

        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (S < -sum || S > sum) {
            return 0;
        }

        int[][] dp = new int[nums.length + 1][2 * sum + 1];
        dp[0][0 + sum] = 1; // 0 + sum means 0, 0 means -sum,  check below graph
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < 2 * sum + 1; j++) {
                if (j + nums[i - 1] < 2 * sum + 1) dp[i][j] += dp[i - 1][j + nums[i - 1]];
                if (j - nums[i - 1] >= 0) dp[i][j] += dp[i - 1][j - nums[i - 1]];
            }
        }
        return dp[nums.length][sum + S];
    }
}

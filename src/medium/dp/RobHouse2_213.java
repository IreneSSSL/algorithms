package medium.dp;

public class RobHouse2_213 {

//    nums[0] and nums[n-1] cannot exist at the same result.
//    so the final result is either [0,n-2] or [1,n-1]
//    try two cases, find the best.
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length ==1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        dp1[0] = nums[0];
        dp1[1] = nums[1]>nums[0]? nums[1]:nums[0];
        dp2[1] = nums[1];
        dp2[2] = nums[1]>nums[2]? nums[1]:nums[2];
        for(int i=2;i<nums.length-1;i++){
            dp1[i] = dp1[i-1] > dp1[i-2]+nums[i] ? dp1[i-1] : dp1[i-2]+nums[i];
        }
        for (int i=3;i<nums.length;i++){
            dp2[i] = dp2[i-1] > dp2[i-2]+nums[i] ? dp2[i-1] : dp2[i-2]+nums[i];

        }
        return dp1[nums.length-2] > dp2[nums.length-1] ?dp1[nums.length-2]:dp2[nums.length-1];

    }
}

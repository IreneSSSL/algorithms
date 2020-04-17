package hard.dp;

public class JumpGame45 {

//    greedy, 非常非常非常快
    public int jump2(int[] nums) {
        if (nums.length <=1) return 0;
        // int[] dp = new int[nums.length];
        int step = 0;
        int maxLength = 0;
        int currentEnd = 0;
        for (int i=0; i<nums.length;i++){
            maxLength = Math.max(maxLength, i+nums[i]);
            if(i == currentEnd){
                step++;
                currentEnd = maxLength;
                if (maxLength == nums.length-1) return step;
            }
        }
        return step;

    }



//    dp very slow
    public int jump(int[] nums) {
        if (nums.length <=1) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i=0;i<nums.length;i++){
            int length = nums[i];
            for (int j=1;j<=length;j++){
                if(dp[i+j]!=0) continue;
                dp[i+j] =dp[i] +1;
                if(dp[nums.length-1] != 0) return dp[dp.length-1];
            }
        }
        return dp[nums.length-1];

    }

}

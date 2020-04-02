package medium.dp;

public class JumpGame55 {

//    my idea, no so fast.
//    my idea focus on each step I CAN arrive at, but it would be faster if focus on the maximum I can arrive at
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int j=0;j< dp.length-1;j++){
            if (dp[j] == 0 ) return false;
            for(int step =1 ; step <= nums[j];step++){
                if (j+ step >= nums.length) return true;
                dp[j+step] = 1;
            }
        }
        if (dp[nums.length-1] == 1) return true;
        return false;
    }

    public boolean canJump2(int[] nums) {
        int max = nums[0];
        if (nums.length == 1 && max >0) return true;
        if (max == 0 && nums.length >1) return false;  // [0 2] false;  [0] true
        for (int i =1;i< nums.length-1;i++){
            max--;
            max = Math.max(max, nums[i]);  // maximum steps I can move forward from position i
            if (max + i >=nums.length) return true;
            if (max == 0 ) return false;
        }
        return true;

    }


}

package medium.dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LongestIncreasingSubsequence300 {


    public static void main(String[] args) {
        int[] a = {0,1,3,5,2,4};
        new LongestIncreasingSubsequence300().lengthOfLIS2(a);
    }

    public int lengthOfLIS2(int[] nums) {
            int[] dp = new int[nums.length];
            int len = 0;
            for (int num : nums) {
                int i = Arrays.binarySearch(dp, 0, len, num);
                if (i < 0) {
                    i = -(i + 1);
                }
                dp[i] = num;
                if (i == len) {
                    len++;
                }
            }
            return len;


    }


    public int lengthOfLIS(int[] nums) {
        int max = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) dp[i] = 1;
            int closest = nums.length;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] > nums[i]) continue;
                if (closest == nums.length) closest = j;
                else if (dp[closest] < dp[j]) {
                    closest = j;
                }
            }
            if (closest != nums.length && nums[i] > nums[closest]) {
                dp[i] = dp[closest] + 1;
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}

package medium.array;

import java.util.HashMap;

public class CountNumberOfNiceSubarrays1248 {

    public static void main(String[] args) {
        int[] n = {2,2,2,1,2,2,1,2,2,2};
        new CountNumberOfNiceSubarrays1248().numberOfSubarrays2(n, 2);
    }

    public int numberOfSubarrays2(int[] nums, int k) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0] % 2;
        for(int i=1;i< nums.length;i++){
            nums[i] = nums[i] %2 ;
            dp[i] = dp[i-1] +nums[i];
        }
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,1);
        int count =0;
        for(int i=0; i<nums.length;i++){
            if ( map.get(dp[i]-k) != null){
                count+= map.get(dp[i]-k);
            }

            if (map.get(dp[i]) == null){
                map.put(dp[i], 1);
            }else {
                map.put(dp[i], map.get(dp[i])+1);
            }
        }
        System.out.println(count);
        return count;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        if (nums.length == 0) return 0;
        int evenStart = 0;
        int evenEnd = 0;
        int oddStart =0;
        int oddEnd =0;
        for (int i=0;i<k-1;i++){
            while (oddEnd < nums.length && nums[oddEnd] %2 == 0) oddEnd++;
            oddEnd++;
        }
        oddEnd++;
        if (oddEnd> nums.length-1) return 0;
        int count = 0;
        while (oddEnd < nums.length){
            while (oddStart < nums.length && nums[oddStart]%2 == 0) oddStart++;
            while (oddEnd < nums.length && nums[oddEnd]%2 == 0) oddEnd++;
            evenEnd = oddEnd+1;
            while (evenEnd< nums.length && nums[evenEnd]%2==0) evenEnd++;
            evenEnd--;
            if (evenEnd < oddEnd) evenEnd = oddEnd;
            if (oddEnd == nums.length || evenEnd == nums.length) break;
            count+= (oddStart - evenStart +1) * (evenEnd-oddEnd+1);
            evenStart = oddStart+1;
            oddStart++;
            oddEnd++;
            evenEnd++;
        }
        return count;

    }
}

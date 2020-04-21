package medium.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class SubArraySum560 {

    public static void main(String[] args) {
        int[] a = {1,2,-1,1,1,1};
        new SubArraySum560().subarraySum2(a,2);
    }


    public int subarraySum2(int[] nums, int k) {
        for(int i=1;i<nums.length;i++)
            nums[i]+=nums[i-1];

        int count=0;
        HashMap<Integer, Integer> hm=new HashMap<>();
        hm.put(0, 1);
        for(int i=0;i<nums.length;i++)
        {
            if(hm.containsKey(nums[i]-k))
                count+=hm.get(nums[i]-k);

            if(hm.containsKey(nums[i]))
                hm.put(nums[i], hm.get(nums[i])+1);
            else
                hm.put(nums[i], 1);
        }

        return count;
    }



    public int subarraySum(int[] nums, int k) {
        int cnt = 0;
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int[][] arrays = new int[dp.length+1][2];
        dp[0] = nums[0];
        arrays[1] = new int[]{dp[0], 0};
        for (int i=1;i<dp.length;i++){
            dp[i] = dp[i-1]+nums[i];
            arrays[i+1] = new int[]{dp[i],i};
        }
        if(k >0){
            Arrays.sort(arrays, new Comparator<int[]>(){
                public int compare(int[] a, int[] b){
                    return a[0]-b[0];
                }
            });
        } else {
            Arrays.sort(arrays, new Comparator<int[]>(){
                public int compare(int[] a, int[] b){
                    return b[0]-a[0];
                }
            });
        }

        for (int i = dp.length; i>0; i--){
            for (int j = i-1;j>=0;j--){
                if (arrays[i][0] - arrays[j][0] == k){
                    if (arrays[i][1]<arrays[j][1]) continue;
                    if (arrays[i][1] ==  0 && arrays[j][1] == 0) {
                        if (arrays[i][0] == arrays[i][1] && arrays[i][0] == 0){
                            if (arrays[j][0] != k) continue;
                        }else {
                            if (arrays[i][0] != k ) continue;
                        }
                    }
                    cnt++;
                }else if (arrays[i][0] - arrays[j][0] > k){
                    break;
                }
            }
        }
        System.out.println(cnt);
        return cnt;
    }

}

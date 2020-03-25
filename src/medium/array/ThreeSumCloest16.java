package medium.array;

import java.util.Arrays;

public class ThreeSumCloest16 {
    public static void main(String[] args) {
        new ThreeSumCloest16().threeSumClosest(new int[]{1,2,4,8,16,32,64,128}, 82);
    }


    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length;i++){
            int start = i+1;
            int end = nums.length -1;
            while(start < end){
                int sum = nums[i]+ nums[start]+nums[end];
                if ( Math.abs(sum -target) < Math.abs(result-target) ){
                    result = sum;
                    if(result == target) return result;  // this line improves the runtime from 8ms to 4ms
                }
                if (nums[i]+ nums[start]+nums[end] -target > 0){
                    end--;
                } else {
                    start++;
                }

            }


        }
        return (int)result;

    }
}

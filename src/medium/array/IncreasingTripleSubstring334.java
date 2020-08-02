package medium.array;

import java.util.Arrays;

public class IncreasingTripleSubstring334 {

//    fastest solution
    public boolean increasingTriplet2(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int secondSmall = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > secondSmall) return true;
            if (num < smallest) {
                smallest = num;
            } else if (num > smallest && num < secondSmall) {
                secondSmall = num;
            }
        }

        return false;
    }

//    my solution
    public boolean increasingTriplet(int[] nums) {
        if (nums.length<3) return false;
        int[] tmp = new int[nums.length];
        int len = 1;
        tmp[0]=nums[0];
        for(int i =1;i<nums.length;i++){
            int index = Arrays.binarySearch(tmp,0,len, nums[i]);
            if (index< 0 ){
                index = -(index+1);
            }
            tmp[index] = nums[i];
            if (index == len) len++;
            if(len == 3) return true;
        }
        return false;
    }
}

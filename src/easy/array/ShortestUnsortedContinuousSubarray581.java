package easy.array;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray581 {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 0) return 0;
        int[] rep = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            rep[i]=nums[i];
        }
        Arrays.sort(rep);
        int start = 0;
        int end=rep.length-1;
        while (start < end && rep[start] == nums[start]) start++;
        while (start < end && rep[end] == nums[end]) end--;
        if (end == start) return 0;
        return end-start+1;
    }

    public int findUnsortedSubarray2(int[] nums) {

        if(nums == null || nums.length <= 1 ) {
            return 0;
        }

        int n = nums[0];

        int leftIndex = 0;
        int rightIndex = nums.length-1;
        for(int i=1;i<nums.length;i++) {
            if(nums[i] < n) {
                leftIndex = i;
            }
            n = Math.max(n, nums[i]);
        }

        if(leftIndex == 0) {
            return 0;
        }

        n = nums[nums.length-1];
        for(int i=nums.length-1; i>=0; i--) {
            if(nums[i] > n) {
                rightIndex = i;
            }
            n = Math.min(n, nums[i]);
        }

        return leftIndex-rightIndex+1;
    }
}

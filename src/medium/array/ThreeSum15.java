package medium.array;

import java.util.*;

public class ThreeSum15 {
    public static void main(String[] args) {
        new ThreeSum15().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }


//    tricky solution , which is sorting the array first
//    fixed one element, then find two elements whose sum is 0-the first element
//    to find the two elements, setting two pointers at the head and tail of the array
//    since it has been sorted, for a target sum, we could just do one time traverse.
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for ( int i=0;i< nums.length; i++) {
            if (i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int target = -nums[i];
            int start = i+1; int end = nums.length-1;
            while (start < end){
                if (nums[start] + nums[end] == target){
                    res.add(Arrays.asList(nums[start], nums[end],nums[i]));
                    while (start+1 < end && nums[start] == nums[start+1]) {start++;}
                    while (end-1 > start && nums[end] == nums[end-1]) {end--;}
                    start++;
                    end--;
                } else if (nums[start] + nums[end] < target){
                    start++;
                } else {
                    end--;
                }
            }

        }
        return res;
    }

}

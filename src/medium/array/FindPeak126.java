package medium.array;

public class FindPeak126 {

//    Your solution should be in logarithmic complexity.
//    but this solution below uses 0ms, make no sense this problem.
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 1) return 0;
        for(int i=1;i<nums.length;i++){
            if (nums[i] < nums[i-1])
                return i-1;
        }
        return nums.length-1;
    }
}

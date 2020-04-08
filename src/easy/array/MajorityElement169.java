package easy.array;

import java.util.Arrays;

public class MajorityElement169 {

//    in the description, the majority will always exist and appears more than floor(n/2) times
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}

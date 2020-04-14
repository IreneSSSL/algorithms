package medium.array;

import java.util.Arrays;

public class FIndDuplicateNum287 {

    public static void main(String[] args) {
        int[] a = new int[]{5,4,5,3,2,1};
        new FIndDuplicateNum287().findDuplicate2(a);
    }

//    seems like fast-slow pointers to locate the start of a cycle in linkedlist
    public int findDuplicate2(int[] nums) {
        if (nums.length > 1) {
            int slow = nums[0], fast = nums[nums[0]];
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            fast = 0;
            while (fast != slow) {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
        return -1;
    }

//        0123456
//        1234556
//        1123456

//        012345
//        123455
//        112345
//        333345

//    sort first, then use binary search to locate the target number
    public int findDuplicate(int[] nums) {
        if (nums.length == 0 ) {return 0;}
        if (nums.length == 1) return 0;
        if (nums.length ==2 ) return 1;
        Arrays.sort(nums);
        int mid = 0+ (nums.length-1)/2;
        int start = 0;
        int end = nums.length-1;
        while (start < end){
            if (nums[start] == nums[end]) return nums[start];
            mid = start +(end-start)/2;
            if(nums[mid] == nums[start] || nums[mid] == nums[end]) return nums[mid];
            if(nums[mid]  > mid ) {
                start = mid;
            }else {
                end = mid;
            }
        }
        return nums[mid];
    }
}

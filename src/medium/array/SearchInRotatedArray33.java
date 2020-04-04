package medium.array;

public class SearchInRotatedArray33 {


//    first, try to find the smallest number's index,
//    then, we could regard this array as two sorted array
//    last, use binary search in a sub sorted array
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1; // [] 5
        if (nums.length == 1) {
            if (nums[0] == target) return 0 ;
            return -1;
        }
        if (nums.length == 2){
            if (nums[0]== target) return 0;
            if (nums[1] == target) return 1;
            return -1;
        }
        int small = FindSmallestNumberIndex(nums, 0, nums.length-1);
        if(small == 0) return search(nums, 0, nums.length-1, target);
        if (target > nums[small-1] || target < nums[small]) return -1;
        if (target >= nums[0]) return search(nums, 0,small-1, target);
        return search(nums, small, nums.length-1, target);
    }


    //     this method does not work when nums's length is 2
    public int FindSmallestNumberIndex(int[] nums, int start, int end){
        if (end - start == 1) return end; // end is the smallest number index;
        int middle = start+ (end-start)/2;
        if (nums[middle] < nums[end]){
            if (nums[start] < nums[middle]) return 0;
            return FindSmallestNumberIndex(nums, start, middle);
        } else {
            return FindSmallestNumberIndex(nums, middle, end);
        }
    }

    public int search(int[] nums, int start, int end, int target){
        if (start >= end){
            if (nums[start] == target) return start;
            return -1;
        }
        int middle = start + (end-start)/2;
        if(target == nums[middle]) return middle;
        if(target < nums[middle]) return search(nums, start, middle-1,target);
        return search(nums, middle+1, end, target);
    }
}

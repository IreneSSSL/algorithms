package medium.array;

import java.util.Arrays;

public class FindKthLargestElement215 {

//    this is not the best solution
    public int findKthLargest(int[] nums, int k) {
        int[] kth = new int[k];
        if(nums.length == k){
            Arrays.sort(nums);
            return nums[0];

        }
        for (int i= 0 ;i < nums.length;i++){
            if (i<k){
                kth[i] = nums[i];
                continue;
            }
            if (i == k) Arrays.sort(kth);
            if ( nums[i] > kth[0] ){
                kth[0] = nums[i];
                Arrays.sort(kth);
            }
        }
        return kth[0];
    }




//    this is the best solution
public int findKthLargest2(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k < 1 || k > nums.length)
        return -1;
    return partition(nums, 0, nums.length - 1, nums.length - k);
}

    private int partition(int[] nums, int start, int end, int k) {
        if (start == end) return nums[k];

        int pivot = nums[(start + end) / 2];
        int left = start, right = end;
        while (left <= right) {
            while (left <= right && nums[left] < pivot)
                left++;
            while (left <= right && nums[right] > pivot)
                right--;

            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }

        if (k <= right)
            return partition(nums, start, right, k);
        else
            return partition(nums, left, end, k);
    }
}

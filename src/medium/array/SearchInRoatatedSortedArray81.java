package medium.array;

public class SearchInRoatatedSortedArray81 {

    public static void main(String[] args) {
        int[] nums = {4,5,2,2,2,2,2};
        System.out.println(new SearchInRoatatedSortedArray81().search(nums, 5));
    }
    public boolean search(int[] nums, int target) {
        if( nums.length == 0) return false;
        int start = 0;
        int end = nums.length-1;
        while ( start <= end && end < nums.length && start >=0){
            if (start == end) {
                if (nums[start]==target) return true;
                return false;
            }
            if (end - start == 1) {
                if (target == nums[start] || target== nums[end]) return true;
                return false;
            }
            int mid = start + (end-start)/2;

            if (nums[mid] == target || target == nums[start]|| nums[end] == target) return true;
            if (nums[mid] == nums[start] && nums[mid]==nums[end]) {
                start++;
                end--;
                continue;
            }
            if (nums[mid] == nums[end]){  // 考虑 5,6,2,2,2,2,2,2 这种情况，断点一定不会在右边。因为上面已经考虑了start==end==mid的情况
                end = mid;
            }else if(nums[mid] == nums[start]){ // 考虑 2,2,2,2,2,5,6  这种情况，断点一定不会在左边
                start = mid+1;
            }
            else if (nums[mid] < nums[end]){
                if (nums[mid] < target && target <= nums[end]){
                    start = mid+1;
                }else {
                    end = mid;
                }
            }else {
                if (nums[start] <= target && target < nums[mid]){
                    end = mid;
                }else {
                    start = mid+1;
                }
            }
        }
        return false;
    }
}

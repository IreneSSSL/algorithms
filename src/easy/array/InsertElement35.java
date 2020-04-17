package easy.array;

public class InsertElement35 {

    public static void main(String[] args) {
        int[] a = {1,3};
        new InsertElement35().searchInsert(a,3);
    }
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0) return 0;
        if (target <= nums[0]) return 0;
        if (target == nums[nums.length-1]) return nums.length-1;
        if (target > nums[nums.length-1]) return nums.length;

        int head = 0;
        int tail = nums.length-1;
        int a = helper(nums, head, tail, target);
        System.out.println(a);
        return a;
    }

    public int helper(int[] nums, int head, int tail, int target){

        if (head == tail) {
            if (target == nums[head]) return head;
            if (target < nums[head]) return head;
            if (target > nums[head]) return head+1;
        }

        int mid = head + (tail - head)/2;
        if (target == nums[mid]) return mid;
        if (target < nums[mid]){
            return helper(nums, head, mid, target);
        }else {
            return helper(nums, mid+1, tail, target);
        }

    }

}

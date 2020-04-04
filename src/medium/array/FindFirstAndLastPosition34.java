package medium.array;

public class FindFirstAndLastPosition34 {
    public static void main(String[] args) {
        int[] a = {1,3,4,4};
        new FindFirstAndLastPosition34().searchRange(a, 4);
    }

//    find the index of target that is closest to middle.
//    find the start of sequence from 0 to index,
//    find the end of the sequence from index+1 to nums.length-1
    public int[] searchRange(int[] nums, int target) {
        int[] re = {-1,-1};
        if (nums.length == 0|| target < nums[0] || target>nums[nums.length-1]) return re;
        if (nums.length == 1){
            if ( nums[0] == target){
                return new int[]{0,0};
            }
            return re;
        }
        int middle = search (nums, 0, nums.length-1, target);
        if(middle == -1) return re;
        startRecord = middle;
        endRecord = middle;
        re[0] = helperStart(nums, 0,middle, target);
        re[1] = helperEnd(nums,middle+1, nums.length-1, target);
        return re;
    }

    int startRecord = 0;
    public int helperStart(int[] nums, int start, int end, int target){
        if (start >= end){
            if (nums[end] == target) return end;
            else return startRecord;
        }
        int index =  search (nums, start, end, target);
        if (index == -1) return startRecord;
        startRecord = Math.min(startRecord, index);
        int middle = start + (end-start)/2;
        if (index <= middle) return helperStart(nums, start, middle, target);
        else return helperStart(nums, middle+1, end, target);
    }


    int endRecord = 0;
    public int helperEnd(int[] nums, int start, int end, int target){
        if (start >= end){
            if (nums[end] == target) return end;
            else return endRecord;
        }
        int index =  search (nums, start, end, target);
        if (index == -1) return endRecord;

        endRecord = Math.max(endRecord, index);
        int middle = start + (end-start)/2;
        if (index < middle) return helperEnd(nums, start, middle, target);
        else return helperEnd(nums, middle+1, end, target);
    }



    public int search(int[] nums, int start, int end, int target){
        if (start >= end){
            if (nums[end] == target) return end;
            else return -1;
        }
        int middle = start + (end-start)/2;
        if (target == nums[middle]) return middle;
        if (target < nums[middle]) return search(nums, start,middle-1, target);
        return search (nums, middle+1, end, target);
    }

}

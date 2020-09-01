package hard.array;

public class FastSortMaximumGap164 {

    boolean[] fixed;
    int max = 0;
    public int maximumGap(int[] nums) {
        if(nums.length <=1) return 0;
        fixed = new boolean[nums.length];
        sort(nums, 0, nums.length-1);
        return max;
    }

//   the major part of this algorithm is FAST SORTING
    public void sort(int[] nums,int start, int end ){
        if(start > end) return;
        int index = quickSort(nums, start, end);
        sort(nums, start, index-1);
        sort(nums, index+1, end);
    }


//    find the right index for nums[start]
//    make all the numbers smaller than nums[start] store at the left part, while the others at the right part
    public int quickSort(int[] nums, int start, int end){
        int pivot = nums[start];
        while(start<end){

//            find the first smaller number at right part
            while(end > start && nums[end]>= pivot) end--;

            if (end > start){
//            exchange the samller number( nums[end] ) with nums[start] that is pivot
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
//             after the exchange, nums[start] is the old nums[end], which is smaller than pivot. so start could increment by 1
                start++;
            }
            while(end>start && nums[start] <= pivot) start++;
            if(end > start){
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
                end--;
            }
        }

//        once we fixed the index of nums[start], we could try to calculate its gap to its fixed neighbors.
        fixed[end] = true;
        if (end-1>=0 && fixed[end-1]) max = Math.max(max, Math.abs(nums[end-1]- nums[end]));
        if(end+1<nums.length && fixed[end+1]) max =  Math.max(max, Math.abs(nums[end+1]- nums[end]));

        return end;
    }

}

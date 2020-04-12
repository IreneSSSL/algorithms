package easy.array;

public class RemoveDupFromSortedArray26 {


//    given a sorted array with duplicated numbers inside.
//    we are asked to put all non-duplicated numbers at the front part of this given array.
//    return the size of the 'front part'
    public int removeDuplicates(int[] nums) {
        if (nums.length  == 0) return 0;
        int i = 0;
        for (int j = 1;j< nums.length;j++){
            if (nums[j] == nums[i]) continue;
            nums[++i] = nums[j];
        }
        return ++i;
    }

}

package medium.array;

public class SortColors75 {

    public static void main(String[] args) {
        int[] a = {2,0,2,1,1,2};
        new SortColors75().sortColors(a);
    }


//    As long as we put 0s and 2s to the right place, the rest 1s will be at where they should be correspondingly.
//    traps:
//    1. in for-loop, if only i< nums.length, right 2s will be removed to the middle at last, so as current pointer meets 2s pointer, it's time to stop
//    2. {2,0,1} extreme case. change to {1,0,2} two pointer at 0, current pointer at 1, dont forget to check the last element!

//    solve it all by myself, proud of myself. hhhhhhhh
    public void sortColors(int[] nums) {
        int zero = 0;
        int two = nums.length -1;
        for(int i = 0;i<= two && i< nums.length;i++){
            if (nums[i] == 0){
                nums = swap(nums, i, zero);
                zero++;
            } else if(nums[i] == 2){
                nums = swap(nums, i, two);
                two--;
                i--;
            }
        }
        System.out.println(nums);
    }

    public int[] swap(int[] nums, int index1,int index2){
        if (index1 == index2) return nums;
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
        return nums;
    }
}

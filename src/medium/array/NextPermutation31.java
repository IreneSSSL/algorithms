package medium.array;

import java.util.Arrays;

public class NextPermutation31 {

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len <=1) return;

        int i=len-1;

        while(i>=1 && nums[i] <= nums[i-1]) i--;
        if ( i >= 1 ) i--;
        else {
            Arrays.sort(nums);
            return;
        }

        int j = len-1;
        while (j>i && nums[j] <= nums[i] ) j--;
        int tmp = nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;

        i = i+1;
        j = len-1;
        while ( i < j){
            tmp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = tmp;
        }
    }

}

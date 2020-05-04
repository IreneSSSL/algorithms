package medium.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ContiguousArray525 {
    public static void main(String[] args) {
        int[] a = {1,0,1,0,1,1,0,0,1,0,0,0,1,0,0,0,1,1,0,1,1,0,1,0,0,1,0,0,1,1,0,0,1,1,1,0,0,1,1,0,0,0,1,1,0,1,1,0,1,1,1,0,1,1,1,0,1,0,1,1,0,0,0,1,0,1,1,0,0,1,1,1,0,0,0,0,0,0,1,1,1,0,0,0,1,1,0,0,1,0,0,0,0,1,0,1,0,0,0,0};
        new ContiguousArray525().findMaxLength(a);
    }



    public int findMaxLength(int[] nums) {
        if (nums.length<=1) return 0;
        int[] sum = new int[nums.length];


        int max = 0;

        int[] s = new int[2*nums.length +1];
        Arrays.fill(s, nums.length + 1);
        s[0] = -1;
        for (int i= 0;i < nums.length;i++){
            if ( i==0 ){
                sum[0] = nums[0] == 0? -1: nums[0];
            }else {
                sum[i] = sum[i-1]+ (nums[i] == 0? -1: nums[i]);   // 求前缀和，如果为0，用-1代替
            }

            int index = sum[i];
            if (sum[i] <= 0 ){
                index= Math.abs(sum[i]);  //前缀和如果为非正数，就用正数代替index
            }else {
                index = nums.length + sum[i] ;  //前缀和如果为正数，就用len+正数代替
            }

            if ( s[index] ==  nums.length + 1 ){
                s[index] = i;
            } else {
                int head = s[index];
                int tail = i;
                max = Math.max(max , tail-head );
            }

        }
        System.out.println(max);
        return max;
    }

}
